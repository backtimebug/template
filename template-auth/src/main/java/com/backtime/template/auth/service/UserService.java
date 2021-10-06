package com.backtime.template.auth.service;

import com.backtime.template.common.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 用户表 服务类
 *
 * @author backtime
 * @since 2021-10-06 09:05:08
 */
public interface UserService extends IService<User>, UserDetailsService {

    User getByEmail(String email);
}
