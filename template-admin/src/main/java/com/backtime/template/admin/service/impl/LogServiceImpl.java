package com.backtime.template.admin.service.impl;

import com.backtime.template.common.entity.Log;
import com.backtime.template.admin.mapper.LogMapper;
import com.backtime.template.admin.service.LogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 日志 服务实现类
 *
 * @author backtime
 * @since 2021-10-06 01:56:14
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {

}
