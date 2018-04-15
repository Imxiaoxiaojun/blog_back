package com.sm.blog.aop;

import com.sm.core.support.HttpKit;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by yj on 2018/4/15.
 */
@Aspect
@Component
public class IPInterceptor {
    Logger log = LoggerFactory.getLogger(this.getClass());


    @Pointcut(value = "@annotation(com.sm.core.base.annotion.IPFilter)")
    public void filter() {
    }
    @Before("filter()")
    public void  ipFilter() throws Throwable{
        log.warn(HttpKit.getIp());
    }
}
