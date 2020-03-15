package com.anuo.blog.service.tb.impl;

import com.anuo.blog.entity.tb.BlogFavourite;
import com.anuo.blog.mapper.tb.BlogFavouriteMapper;
import com.anuo.blog.service.tb.IBlogFavouriteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 收藏博客 服务实现类
 * </p>
 *
 * @author yan
 * @since 2020-03-14
 */
@Service
public class BlogFavouriteService extends ServiceImpl<BlogFavouriteMapper, BlogFavourite> implements IBlogFavouriteService {

}
