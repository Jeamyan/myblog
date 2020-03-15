package com.anuo.blog.entity.sys;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 系统权限表
 * </p>
 *
 * @author yan
 * @since 2020-03-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_permissions")
@ApiModel(value="Permissions对象", description="系统权限表")
public class Permissions implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "父节点id")
    private Integer parentId;

    @ApiModelProperty(value = "权限名称")
    private String permissionsName;

    @ApiModelProperty(value = "权限标签")
    private String permissionsElement;

    @ApiModelProperty(value = "权限类型 菜单  按钮  0 功能菜单 1 按钮")
    private Integer permissionsType;

    @ApiModelProperty(value = "状态（0、禁用，1、启用）")
    private Boolean permissionsStatus;

    @ApiModelProperty(value = "0:未删除 1:已删除")
    private String isDelete;

    @ApiModelProperty(value = "备注")
    private String permissionsRemark;

    private String createUserCode;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    private String updateUserCode;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version
    private Integer version;


}
