package com.backtime.template.common.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色表实体类
 *
 * @author backtime
 * @since 2021-10-06 01:56:14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_role")
@ApiModel(value="Role对象", description="角色表")
public class Role implements Serializable {

    @TableId
    @ApiModelProperty(value = "角色id")
    private String roleId;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "是否超级管理员  true-是 false-否")
    private Boolean isSuper;

    @ApiModelProperty(value = "是否管理员 true-是 false-否")
    private Boolean isManager;

    @ApiModelProperty(value = "是否可删除 true-是 false-否")
    private Boolean canDelete;

    @ApiModelProperty(value = "是否删除  true-是 false-否")
    private Boolean isDelete;

    private Date createTime;

    private String createUserId;

    private String createUserName;

    private Date updateTime;

    private String updateUserId;

    private String updateUserName;


}
