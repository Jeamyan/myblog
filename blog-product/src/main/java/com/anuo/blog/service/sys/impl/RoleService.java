package com.anuo.blog.service.sys.impl;

import com.anuo.blog.entity.sys.Role;
import com.anuo.blog.mapper.sys.RoleMapper;
import com.anuo.blog.service.sys.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统角色 服务实现类
 * </p>
 *
 * @author yan
 * @since 2020-03-14
 */
@Service
public class RoleService extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
