package com.anuo.blog.service.tb.impl;

import com.anuo.blog.entity.tb.BlogComment;
import com.anuo.blog.mapper.tb.BlogCommentMapper;
import com.anuo.blog.service.tb.IBlogCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客评论表 服务实现类
 * </p>
 *
 * @author yan
 * @since 2020-03-14
 */
@Service
public class BlogCommentService extends ServiceImpl<BlogCommentMapper, BlogComment> implements IBlogCommentService {

}
