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
 * 菜单实体类
 *
 * @author backtime
 * @since 2021-10-06 01:56:14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_menu")
@ApiModel(value="Menu对象", description="菜单")
public class Menu implements Serializable {

    @TableId
    @ApiModelProperty(value = "菜单编号")
    private String menuId;

    @ApiModelProperty(value = "菜单名称")
    private String menuName;

    @ApiModelProperty(value = "父菜单编号")
    private String parentId;

    @ApiModelProperty(value = "菜单标题")
    private String title;

    @ApiModelProperty(value = "路径")
    private String path;

    @ApiModelProperty(value = "重定向地址")
    private String redirect;

    @ApiModelProperty(value = "组件路径")
    private String component;

    private Boolean alwaysShow;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "菜单类型，'D'目录，‘M’菜单，‘B’按钮")
    private String type;

    @ApiModelProperty(value = "菜单是否隐藏（加载但不显示）")
    private Boolean hidden;

    @ApiModelProperty(value = "是否缓存")
    private Boolean noCache;

    @ApiModelProperty(value = "菜单是否显示（false时菜单树不会加载）")
    private Boolean isShow;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "逻辑删除")
    private Boolean isDelete;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建用户编号")
    private String createUserId;

    @ApiModelProperty(value = "创建用户姓名")
    private String createUserName;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "更新用户编号")
    private String updateUserId;

    @ApiModelProperty(value = "更新用户姓名")
    private String updateUserName;


}
