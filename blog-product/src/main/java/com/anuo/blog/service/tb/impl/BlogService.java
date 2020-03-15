package com.anuo.blog.service.tb.impl;

import com.anuo.blog.entity.tb.Blog;
import com.anuo.blog.mapper.tb.BlogMapper;
import com.anuo.blog.service.tb.IBlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客表 服务实现类
 * </p>
 *
 * @author yan
 * @since 2020-03-14
 */
@Service
public class BlogService extends ServiceImpl<BlogMapper, Blog> implements IBlogService {

}
