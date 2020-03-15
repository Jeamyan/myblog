package com.anuo.blog.service.tb.impl;

import com.anuo.blog.entity.tb.BlogCategory;
import com.anuo.blog.mapper.tb.BlogCategoryMapper;
import com.anuo.blog.service.tb.IBlogCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客分类 服务实现类
 * </p>
 *
 * @author yan
 * @since 2020-03-14
 */
@Service
public class BlogCategoryService extends ServiceImpl<BlogCategoryMapper, BlogCategory> implements IBlogCategoryService {

}
