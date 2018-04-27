package com.sm.blog.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sm.core.base.warpper.ResultWarpper;
import com.sm.core.support.HttpKit;
import com.sm.core.util.ToolUtil;
import org.slf4j.Logger;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by yj on 2018/4/15.
 */
@Component
@ConfigurationProperties(prefix = "blog")
public class IPFilter implements Filter{
    private String[] whiteIp;
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(IPFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        log.warn(HttpKit.getRequest().getParameter("ClientIp"));
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String originHeader=((HttpServletRequest) request).getHeader("Origin");
        if (true) {
            httpResponse.setHeader("Access-Control-Allow-Origin", originHeader);
            httpResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Connection, User-Agent, Cookie");
            httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        }

        if(ToolUtil.isEmpty(whiteIp) || !Arrays.asList(whiteIp).contains(HttpKit.getIp())){
            log.warn("过滤非白名单IP" + HttpKit.getIp());
            httpResponse.setCharacterEncoding("UTF-8");
            httpResponse.setContentType("application/json; charset=utf-8");
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            ObjectMapper mapper = new ObjectMapper();
            ResultWarpper result = new ResultWarpper(3002,"您无权限访问");
            httpResponse.getWriter().write(mapper.writeValueAsString(result));
            return;
        }
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
