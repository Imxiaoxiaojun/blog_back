package com.sm.blog.service.impl;

import com.sm.blog.model.OperationLog;
import com.sm.blog.dao.OperationLogMapper;
import com.sm.blog.service.IOperationLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志 服务实现类
 * </p>
 *
 * @author 'zhuyajun@maoyan.com123
 * @since 2018-04-15
 */
@Service
public class OperationLogServiceImpl extends ServiceImpl<OperationLogMapper, OperationLog> implements IOperationLogService {

}
