package com.sm.blog.log;

import com.sm.blog.model.OperationLog;

/**
 * 日志工厂类
 * Created by yj on 2018/4/15.
 */
public class LogFactory {
    /**
     * 创建操作日志
     * @param logType 日志类型
     * @param userId 用户标志
     * @param logName 业务名称
     * @param msg 备注
     * @param status 状态
     * @return
     */
    public static OperationLog createOperationLog(String logType, String userId, String logName,String msg, String status) {
        OperationLog operationLog = new OperationLog();
        operationLog.setLogType(logType);
        operationLog.setLogName(logName);
        operationLog.setUserId(userId);
        operationLog.setStatus(status);
        operationLog.setMessage(msg);
        return operationLog;
    }
}
