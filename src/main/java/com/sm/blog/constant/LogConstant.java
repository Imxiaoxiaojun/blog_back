package com.sm.blog.constant;

/**
 * 日志常亮
 * Created by yj on 2018/4/15.
 */
public enum LogConstant {
    EXCEPTION("异常日志"),
    STATUS_FAIL("fail"),
    STATUS_SUCCESS("success");

    String message;

    LogConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
