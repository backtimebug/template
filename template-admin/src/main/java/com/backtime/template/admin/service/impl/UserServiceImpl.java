package com.backtime.template.admin.service.impl;

import com.backtime.template.common.entity.Role;
import com.backtime.template.common.entity.User;
import com.backtime.template.admin.mapper.UserMapper;
import com.backtime.template.admin.service.RoleService;
import com.backtime.template.admin.service.UserService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户表 服务实现类
 *
 * @author backtime
 * @since 2021-10-06 01:56:14
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private RoleService roleService;

    @Override
    public User getByEmail(String email) {
        LambdaQueryWrapper<User> condition = Wrappers.lambdaQuery();
        condition.eq(User::getEmail, email);
        return baseMapper.selectOne(condition);
    }

    @Override
    public User getByPhone(String phone) {
        LambdaQueryWrapper<User> condition = Wrappers.lambdaQuery();
        condition.eq(User::getPhone, phone);
        return baseMapper.selectOne(condition);
    }

    @Override
    public User getByUniqueKey(String value) {
        LambdaQueryWrapper<User> condition = Wrappers.lambdaQuery();
        condition.eq(User::getEmail, value).or().eq(User::getPhone, value);
        return baseMapper.selectOne(condition);
    }

}
