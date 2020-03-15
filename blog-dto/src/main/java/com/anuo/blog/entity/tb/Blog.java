package com.anuo.blog.entity.tb;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

/**
 * <p>
 * 博客表
 * </p>
 *
 * @author yan
 * @since 2020-03-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_blog")
@ApiModel(value="Blog对象", description="博客表")
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "标题")
    private String blogTitle;

    @ApiModelProperty(value = "内容")
    private Blob blogContent;

    @ApiModelProperty(value = "博客分类id")
    private Boolean categoryId;

    @ApiModelProperty(value = "分类名称")
    private String categoryName;

    @ApiModelProperty(value = "点赞数")
    private Integer praiseNum;

    @ApiModelProperty(value = "封面")
    private String blogCoverImage;

    @ApiModelProperty(value = "标签(新颖,优秀)")
    private String blogTags;

    @ApiModelProperty(value = "浏览数")
    private Integer viewNum;

    @ApiModelProperty(value = "评论数")
    private Integer commentNum;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    private String createUserCode;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    private String updateUserCode;

    @Version
    private Integer version;

    private Boolean isDelete;


}
