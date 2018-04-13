package com.sm.blog.service.impl;

import com.sm.blog.model.IpLog;
import com.sm.blog.dao.IpLogMapper;
import com.sm.blog.service.IIpLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 'zhuyajun@maoyan.com
 * @since 2018-04-13
 */
@Service
public class IpLogServiceImpl extends ServiceImpl<IpLogMapper, IpLog> implements IIpLogService {

}
