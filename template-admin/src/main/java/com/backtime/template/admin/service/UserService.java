package com.backtime.template.admin.service;

import com.backtime.template.common.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 用户表 服务类
 *
 * @author backtime
 * @since 2021-10-06 01:56:14
 */
public interface UserService extends IService<User> {

    User getByEmail(String email);

    User getByPhone(String phone);

    User getByUniqueKey(String value);

}
