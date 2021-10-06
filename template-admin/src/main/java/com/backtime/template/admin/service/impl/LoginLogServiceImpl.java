package com.backtime.template.admin.service.impl;

import com.backtime.template.common.entity.LoginLog;
import com.backtime.template.admin.mapper.LoginLogMapper;
import com.backtime.template.admin.service.LoginLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 登录日志 服务实现类
 *
 * @author backtime
 * @since 2021-10-06 01:56:14
 */
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements LoginLogService {

}
