package com.anuo.blog.service.tb.impl;

import com.anuo.blog.entity.tb.BlogTag;
import com.anuo.blog.mapper.tb.BlogTagMapper;
import com.anuo.blog.service.tb.IBlogTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客标签 服务实现类
 * </p>
 *
 * @author yan
 * @since 2020-03-14
 */
@Service
public class BlogTagService extends ServiceImpl<BlogTagMapper, BlogTag> implements IBlogTagService {

}
