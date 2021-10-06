package com.backtime.template.admin.mapper;

import com.backtime.template.common.entity.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户角色表 Mapper 接口
 *
 * @author backtime
 * @since 2021-10-06 01:56:14
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {
    /**
    * 插入非空字段
    * @param record
    * @param insertEmptyString 是否允许插入空串, true-允许，false-不允许
    * @return
    */
    int insertSelective(@Param("record") UserRole record, @Param("insertEmptyString") boolean insertEmptyString);

    /**
    * 插入非空字段
    * @param record
    * @param updateEmptyString 是否允许插入空串, true-允许，false-不允许
    * @return
    */
    int updateByIdSelective(@Param("record") UserRole record, @Param("updateEmptyString") boolean updateEmptyString);

 }
