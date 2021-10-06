package com.backtime.template.admin.service.impl;

import com.backtime.template.common.entity.Role;
import com.backtime.template.admin.mapper.RoleMapper;
import com.backtime.template.admin.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色表 服务实现类
 *
 * @author backtime
 * @since 2021-10-06 01:56:14
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Override
    public List<Role> queryByUserId(String userId) {
        return baseMapper.queryByUserId(userId);
    }
}
