package com.sm.blog.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sm.blog.constant.ResponseCode;
import com.sm.core.base.service.RedisService;
import com.sm.core.base.warpper.ResultWarpper;
import com.sm.core.support.HttpKit;
import com.sm.core.util.ToolUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yj on 2018/4/15.
 */
@Component
@ConfigurationProperties(prefix = "blog")
public class IPFilter implements Filter{
    private String[] whiteIp;
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(IPFilter.class);

    @Autowired
    private RedisService redisService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String remoteIp = HttpKit.getIp();

        HttpServletResponse httpResponse = (HttpServletResponse) response;
        log.info("remoteIp=====" + remoteIp);
        log.info("filter Proxy-Client-IP" + HttpKit.getRequest().getHeader("x-forwarded-for"));
        log.info("filter WL-Proxy-Client-IP" + HttpKit.getRequest().getHeader("x-forwarded-for"));
        log.info("filter RemoteAddr" + HttpKit.getRequest().getRemoteAddr());

        /**
         * 前后端分离跨域
         */
        if(true){
            String originHeader=((HttpServletRequest) request).getHeader("Origin");
            httpResponse.setHeader("Access-Control-Allow-Origin", originHeader);
            httpResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Connection, User-Agent, Cookie");
            httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        }

        int reqNum = 0;
        if (redisService.exists(remoteIp + RedisService.TOKEN_TYPE)){
            Map<String,Object> map = (Map) redisService.get(remoteIp + RedisService.TOKEN_TYPE);
            reqNum = (Integer) map.get("cacheReqNum");
            String cacheToken =  String.valueOf(map.get("token"));
            String token = ((HttpServletRequest) request).getHeader("token");

            if ((StringUtils.isNotBlank(token) && !StringUtils.equals(token, cacheToken)) ||
                    (StringUtils.isBlank(token) && reqNum > 10)) {
                ObjectMapper mapper = new ObjectMapper();
                ResultWarpper result = new ResultWarpper(ResponseCode.REQUEST_ILLEGAL, "非法请求");
                httpResponse.getWriter().write(mapper.writeValueAsString(result));
                return;
            }
            reqNum += 1;
        }

        String newToken = ToolUtil.getRandStr(6);
        Map map = new HashMap(2);
        map.put("cacheReqNum",reqNum);
        map.put("token",newToken);
        redisService.set(remoteIp + RedisService.TOKEN_TYPE,map,RedisService.TWO_HOUR);

        if(ToolUtil.isEmpty(whiteIp) || !Arrays.asList(whiteIp).contains(HttpKit.getIp())){
            httpResponse.setCharacterEncoding("UTF-8");
            httpResponse.setContentType("application/json; charset=utf-8");
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            ObjectMapper mapper = new ObjectMapper();
            ResultWarpper result = new ResultWarpper(ResponseCode.REQUEST_NONEAUTH,"您无权限访问");
            httpResponse.getWriter().write(mapper.writeValueAsString(result));
            return;
        }

        Cookie tokenCookie = new Cookie("TOKEN_COOKIE",ToolUtil.encode(map));
        ((HttpServletResponse) response).addCookie(tokenCookie);
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
    public void setWhiteIp(String[] whiteIp){
        this.whiteIp = whiteIp;
    }

    public String[] getWhiteIp() {
        return whiteIp;
    }
}
