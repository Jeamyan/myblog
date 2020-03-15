package com.anuo.blog.service.sys.impl;

import com.anuo.blog.entity.sys.User;
import com.anuo.blog.mapper.sys.UserMapper;
import com.anuo.blog.service.sys.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author yan
 * @since 2020-03-14
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {

}
