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
 * 登录日志实体类
 *
 * @author backtime
 * @since 2021-10-06 01:56:14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_login_log")
@ApiModel(value="LoginLog对象", description="登录日志")
public class LoginLog implements Serializable {

    @TableId
    @ApiModelProperty(value = "登录日志编号")
    private String loginLogId;

    @ApiModelProperty(value = "登录用户编号")
    private String userId;

    @ApiModelProperty(value = "登录用户姓名")
    private String userName;

    @ApiModelProperty(value = "登录时间")
    private Date time;

    @ApiModelProperty(value = "登录IP")
    private String ip;

    @ApiModelProperty(value = "mac地址")
    private String macAddress;

    @ApiModelProperty(value = "IP所在城市")
    private String address;

    @ApiModelProperty(value = "浏览器")
    private String browser;

    @ApiModelProperty(value = "操作系统")
    private String os;


}
