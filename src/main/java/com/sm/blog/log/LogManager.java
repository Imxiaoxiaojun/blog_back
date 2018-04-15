package com.sm.blog.log;

import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 日志管理器
 * Created by yj on 2018/4/15.
 */
public class LogManager {
    //日志记录操作延时
    private final int OPERATE_DELAY_TIME = 15 * 1000;
    private ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10);

    private LogManager() {
    }
    public static LogManager logManager = new LogManager();
    public static LogManager me() {
        return logManager;
    }
    public void executeLog(TimerTask task) {
        executor.schedule(task, OPERATE_DELAY_TIME, TimeUnit.MILLISECONDS);
    }
}
