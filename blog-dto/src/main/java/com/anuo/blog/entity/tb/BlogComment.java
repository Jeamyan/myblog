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
 * 博客评论表
 * </p>
 *
 * @author yan
 * @since 2020-03-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_blog_comment")
@ApiModel(value="BlogComment对象", description="博客评论表")
public class BlogComment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "博客id")
    private Integer blogId;

    @ApiModelProperty(value = "评论内容")
    private String commentBody;

    @ApiModelProperty(value = "回复内容")
    private String replyBody;

    @ApiModelProperty(value = "回复时间")
    private Date replyTime;

    private Boolean isDelete;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    private String createUserCode;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version
    private Integer version;


}
