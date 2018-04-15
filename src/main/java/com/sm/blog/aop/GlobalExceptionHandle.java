package com.sm.blog.aop;

import com.sm.blog.log.LogManager;
import com.sm.blog.log.LogTaskFactory;
import com.sm.core.base.constant.BizExceptionEnum;
import com.sm.core.base.warpper.ResultWarpper;
import com.sm.core.support.HttpKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 全局异常拦截 带@RequestMapping 的方法都会拦截
 * Created by yj on 2018/4/15.
 */
@ControllerAdvice
@Order(-1)
public class GlobalExceptionHandle {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResultWarpper unknownError(RuntimeException e) {
        LogManager.me().executeLog(LogTaskFactory.exceptionLog(HttpKit.getIp(), e));
        log.error("运行时异常:", e);
        return new ResultWarpper(BizExceptionEnum.SERVER_ERROR.getCode(), BizExceptionEnum.SERVER_ERROR.getMessage());
    }
}
