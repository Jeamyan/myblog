package com.anuo.blog.service.sys.impl;

import com.anuo.blog.entity.sys.RoleUser;
import com.anuo.blog.mapper.sys.RoleUserMapper;
import com.anuo.blog.service.sys.IRoleUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统角色(岗位)人员表 服务实现类
 * </p>
 *
 * @author yan
 * @since 2020-03-14
 */
@Service
public class RoleUserService extends ServiceImpl<RoleUserMapper, RoleUser> implements IRoleUserService {

}
