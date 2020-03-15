package com.anuo.blog.service.tb.impl;

import com.anuo.blog.entity.tb.Link;
import com.anuo.blog.mapper.tb.LinkMapper;
import com.anuo.blog.service.tb.ILinkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客链接 服务实现类
 * </p>
 *
 * @author yan
 * @since 2020-03-14
 */
@Service
public class LinkService extends ServiceImpl<LinkMapper, Link> implements ILinkService {

}
