package com.backtime.template.auth.service;

import com.backtime.template.common.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 角色表 服务类
 *
 * @author backtime
 * @since 2021-10-06 09:05:08
 */
public interface RoleService extends IService<Role> {

    List<Role> queryByUserId(String userId);

}
