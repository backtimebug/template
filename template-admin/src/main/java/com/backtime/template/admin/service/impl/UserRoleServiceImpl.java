package com.backtime.template.admin.service.impl;

import com.backtime.template.common.entity.UserRole;
import com.backtime.template.admin.mapper.UserRoleMapper;
import com.backtime.template.admin.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户角色表 服务实现类
 *
 * @author backtime
 * @since 2021-10-06 01:56:14
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
