package com.backtime.template.admin.mapper;

import com.backtime.template.common.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 角色表 Mapper 接口
 *
 * @author backtime
 * @since 2021-10-06 01:56:14
 */
public interface RoleMapper extends BaseMapper<Role> {
    /**
    * 插入非空字段
    * @param record
    * @param insertEmptyString 是否允许插入空串, true-允许，false-不允许
    * @return
    */
    int insertSelective(@Param("record") Role record, @Param("insertEmptyString") boolean insertEmptyString);

    /**
    * 插入非空字段
    * @param record
    * @param updateEmptyString 是否允许插入空串, true-允许，false-不允许
    * @return
    */
    int updateByIdSelective(@Param("record") Role record, @Param("updateEmptyString") boolean updateEmptyString);

    @Select("select sys_role.role_id,sys_role.role_name " +
            "from sys_role,sys_user_role " +
            "where sys_user_role.user_id = #{userId} " +
            "and sys_role.role_id = sys_user_role.role_id")
    List<Role> queryByUserId(String userId);
}
