package com.backtime.template.admin.mapper;

import com.backtime.template.common.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 菜单 Mapper 接口
 *
 * @author backtime
 * @since 2021-10-06 01:56:14
 */
public interface MenuMapper extends BaseMapper<Menu> {
    /**
    * 插入非空字段
    * @param record
    * @param insertEmptyString 是否允许插入空串, true-允许，false-不允许
    * @return
    */
    int insertSelective(@Param("record") Menu record, @Param("insertEmptyString") boolean insertEmptyString);

    /**
    * 插入非空字段
    * @param record
    * @param updateEmptyString 是否允许插入空串, true-允许，false-不允许
    * @return
    */
    int updateByIdSelective(@Param("record") Menu record, @Param("updateEmptyString") boolean updateEmptyString);

 }
