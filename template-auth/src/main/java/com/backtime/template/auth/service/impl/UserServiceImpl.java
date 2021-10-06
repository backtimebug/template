package com.backtime.template.auth.service.impl;

import com.backtime.template.auth.service.RoleService;
import com.backtime.template.common.entity.Role;
import com.backtime.template.common.entity.User;
import com.backtime.template.auth.mapper.UserMapper;
import com.backtime.template.auth.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户表 服务实现类
 *
 * @author backtime
 * @since 2021-10-06 09:05:08
 */
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
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = this.getByEmail(email);
        if (null == user) {
            throw new UsernameNotFoundException("用户不存在");
        }
        List<Role> roles = roleService.queryByUserId(user.getUserId());
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        user.setAuthorities(authorities);
        return user;
    }
}
