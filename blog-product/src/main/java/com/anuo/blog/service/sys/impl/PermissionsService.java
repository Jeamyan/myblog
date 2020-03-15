package com.anuo.blog.service.sys.impl;

import com.anuo.blog.entity.sys.Permissions;
import com.anuo.blog.mapper.sys.PermissionsMapper;
import com.anuo.blog.service.sys.IPermissionsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统权限表 服务实现类
 * </p>
 *
 * @author yan
 * @since 2020-03-14
 */
@Service
public class PermissionsService extends ServiceImpl<PermissionsMapper, Permissions> implements IPermissionsService {

}
