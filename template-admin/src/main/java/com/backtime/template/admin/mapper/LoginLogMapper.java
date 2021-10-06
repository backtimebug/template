package com.backtime.template.admin.mapper;

import com.backtime.template.common.entity.LoginLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 登录日志 Mapper 接口
 *
 * @author backtime
 * @since 2021-10-06 01:56:14
 */
public interface LoginLogMapper extends BaseMapper<LoginLog> {
    /**
    * 插入非空字段
    * @param record
    * @param insertEmptyString 是否允许插入空串, true-允许，false-不允许
    * @return
    */
    int insertSelective(@Param("record") LoginLog record, @Param("insertEmptyString") boolean insertEmptyString);

    /**
    * 插入非空字段
    * @param record
    * @param updateEmptyString 是否允许插入空串, true-允许，false-不允许
    * @return
    */
    int updateByIdSelective(@Param("record") LoginLog record, @Param("updateEmptyString") boolean updateEmptyString);

 }
