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
 * 日志实体类
 *
 * @author backtime
 * @since 2021-10-06 01:56:14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_log")
@ApiModel(value="Log对象", description="日志")
public class Log implements Serializable {

    @TableId
    @ApiModelProperty(value = "日志编号")
    private String logId;

    @ApiModelProperty(value = "表名")
    private String tableName;

    @ApiModelProperty(value = "请求类型")
    private String type;

    @ApiModelProperty(value = "方法")
    private String method;

    @ApiModelProperty(value = "操作类型")
    private String operation;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "IP地址")
    private String ip;

    @ApiModelProperty(value = "状态")
    private Boolean state;

    @ApiModelProperty(value = "创建时间")
    private Date createAt;

    @ApiModelProperty(value = "操作用户编号")
    private String userId;

    @ApiModelProperty(value = "操作用户姓名")
    private String userName;


}
