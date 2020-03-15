package com.anuo.blog.service.tb.impl;

import com.anuo.blog.entity.tb.BlogTagRelation;
import com.anuo.blog.mapper.tb.BlogTagRelationMapper;
import com.anuo.blog.service.tb.IBlogTagRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客标签关系表 服务实现类
 * </p>
 *
 * @author yan
 * @since 2020-03-14
 */
@Service
public class BlogTagRelationService extends ServiceImpl<BlogTagRelationMapper, BlogTagRelation> implements IBlogTagRelationService {

}
