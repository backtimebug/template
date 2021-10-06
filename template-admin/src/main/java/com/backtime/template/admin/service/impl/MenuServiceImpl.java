package com.backtime.template.admin.service.impl;

import com.backtime.template.common.entity.Menu;
import com.backtime.template.admin.mapper.MenuMapper;
import com.backtime.template.admin.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 菜单 服务实现类
 *
 * @author backtime
 * @since 2021-10-06 01:56:14
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

}
