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
 * 博客分类
 * </p>
 *
 * @author yan
 * @since 2020-03-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_blog_category")
@ApiModel(value="BlogCategory对象", description="博客分类")
public class BlogCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "分类名称")
    private String categoryName;

    @ApiModelProperty(value = "分类icon")
    private String categoryIcon;

    @ApiModelProperty(value = "排序")
    private Integer categoryRank;

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
