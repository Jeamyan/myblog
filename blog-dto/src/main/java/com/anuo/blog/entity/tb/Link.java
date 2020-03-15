package com.anuo.blog.entity.tb;

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
 * 博客链接
 * </p>
 *
 * @author yan
 * @since 2020-03-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_link")
@ApiModel(value="Link对象", description="博客链接")
public class Link implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private Integer id;

    @ApiModelProperty(value = "0-友链 1-推荐 2-个人网站")
    private Integer linkType;

    @ApiModelProperty(value = "网站名称")
    private String linkName;

    @ApiModelProperty(value = "网站链接")
    private String linkUrl;

    @ApiModelProperty(value = "网站描述")
    private String linkDescription;

    @ApiModelProperty(value = "用于列表排序")
    private Integer linkRank;

    @ApiModelProperty(value = "0-未删除 1-已删除")
    private Boolean isDelete;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    private String createUserCode;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    private String updateUserCode;

    @Version
    private Integer version;


}
