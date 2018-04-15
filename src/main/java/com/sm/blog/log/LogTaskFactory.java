package com.sm.blog.log;

import com.sm.blog.constant.LogConstant;
import com.sm.blog.dao.OperationLogMapper;
import com.sm.blog.model.OperationLog;
import com.sm.core.util.MapperUtil;
import com.sm.core.util.ToolUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;

/**
 * 日志操作任务创建工厂
 * Created by yj on 2018/4/15.
 */
public class LogTaskFactory {
    private static Logger logger = LoggerFactory.getLogger(LogManager.class);
    private static OperationLogMapper operationLogMapper = MapperUtil.getMapper(OperationLogMapper.class);


    public static TimerTask exceptionLog(final String userId, final Exception exception) {
        return new TimerTask() {
            @Override
            public void run() {
                String msg = ToolUtil.getExceptionMsg(exception);
                OperationLog operationLog = LogFactory.createOperationLog(LogConstant.EXCEPTION.getMessage(), userId, "", msg, LogConstant.STATUS_FAIL.getMessage());
                try {
                    operationLogMapper.insert(operationLog);
                } catch (Exception e) {
                    logger.error("创建异常日志异常!", e);
                }
            }
        };
    }
}
