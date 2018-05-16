package com.sm.blog.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sm.blog.constant.CommonConstant;
import com.sm.blog.constant.ResponseCode;
import com.sm.core.base.service.RedisService;
import com.sm.core.base.warpper.ResultWarpper;
import com.sm.core.support.HttpKit;
import com.sm.core.util.DateUtil;
import com.sm.core.util.ToolUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yj on 2018/4/15.
 */
@Component
@ConfigurationProperties(prefix = "blog")
public class IPFilter implements Filter {
    private String[] whiteIp;
    private int allowedErrorReqNum;
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(IPFilter.class);

    @Autowired
    private RedisService redisService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String remoteIp = HttpKit.getRequest().getHeader("X-Forwarded-For");
        String realIp = HttpKit.getRequest().getHeader("X-Real-IP");
        String referer = HttpKit.getRequest().getHeader("Referer");
        String remoteAddress = HttpKit.getRequest().getRemoteAddr();
        log.info("ForwardIp =" + remoteIp + "&&RealIP=" + realIp + "&&RemoteAddress=" + remoteAddress + "&&referer=" + referer);

        /**
         * 前后端分离跨域
         */

        HttpServletResponse httpResponse = (HttpServletResponse) response;
        ServletOutputStream out = httpResponse.getOutputStream();
        httpResponse.setCharacterEncoding("UTF-8");
        httpResponse.setContentType("application/json; charset=utf-8");
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
//        if (true) {
//            String originHeader = ((HttpServletRequest) request).getHeader("Origin");
//            httpResponse.setHeader("Access-Control-Allow-Origin", originHeader);
//            httpResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Connection, User-Agent, Cookie,Token");
//            httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
//            httpResponse.setHeader("Access-Control-Max-Age", "1728000");
//        }


        if (redisService.checkMember(RedisService.BLACK_LIST,remoteIp)){
                httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                ObjectMapper mapper = new ObjectMapper();
                ResultWarpper result = new ResultWarpper(ResponseCode.REQUEST_ILLEGAL, "非法请求次数过多，IP锁定中");
                out.write(mapper.writeValueAsString(result).getBytes());
            return;
        }

        boolean setCookie = false;
        int reqNum = 0;
        boolean doChain = true;
        String token = ((HttpServletRequest) request).getHeader("token");
        String newToken = null;//有效一分钟，允许错误6次，超过6次加入黑名单列表
        if (!CommonConstant.LOCALIP.contains(remoteIp)){
            if (redisService.exists(remoteIp + RedisService.TOKEN_TYPE)) {
                Map<String,Object> map = (Map) redisService.get(remoteIp + RedisService.TOKEN_TYPE);
                reqNum = (Integer) map.get("cacheReqNum");
                String cacheToken = String.valueOf(map.get("token"));

                if (!StringUtils.equals(token, cacheToken)) {
                    reqNum += 1;
                    if (reqNum > allowedErrorReqNum){
                        redisService.remove(remoteIp + RedisService.TOKEN_TYPE);
                        redisService.add(RedisService.BLACK_LIST, remoteIp, DateUtil.getRemainTime() / 1000l);
                        return;
                    }
                    map.put("cacheReqNum", reqNum);
                /*httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                ObjectMapper mapper = new ObjectMapper();
                ResultWarpper result = new ResultWarpper(ResponseCode.REQUEST_ILLEGAL, "非法请求!");
                out.write(mapper.writeValueAsString(result).getBytes());*/

                    setCookie = true;
                    newToken = cacheToken;
//                doChain = false;

                    redisService.set(remoteIp + RedisService.TOKEN_TYPE, map);
                }

            }else {
                setCookie = true;
                newToken = ToolUtil.getRandStr(6);
                Map map = new HashMap(2);
                map.put("cacheReqNum", reqNum + 1);
                map.put("token",newToken);
                redisService.set(remoteIp + RedisService.TOKEN_TYPE, map, RedisService.TWO_MINUTE);
            }
        }

        if (setCookie){
            Cookie tokenCookie = new Cookie("TOKEN_COOKIE", newToken);
            tokenCookie.setMaxAge(60 * 60 * 24);
            tokenCookie.setPath("/");
            httpResponse.addCookie(tokenCookie);
            out.flush();
        }
        if (doChain) {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }

    public void setWhiteIp(String[] whiteIp) {
        this.whiteIp = whiteIp;
    }

    public String[] getWhiteIp() {
        return whiteIp;
    }

    public int getAllowedErrorReqNum() {
        return allowedErrorReqNum;
    }

    public void setAllowedErrorReqNum(int allowedErrorReqNum) {
        this.allowedErrorReqNum = allowedErrorReqNum;
    }
}
