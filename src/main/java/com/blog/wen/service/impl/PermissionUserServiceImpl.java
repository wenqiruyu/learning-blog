package com.blog.wen.service.impl;

import com.blog.wen.entity.UserDetailsImpl;
import com.blog.wen.mapper.IUserDetailsMapper;
import com.blog.wen.service.IPermissionUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 项目名称：learning-blog
 * 类名称：PermissionUserServiceImpl
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/10/15
 * 修改人：yingx
 * 修改时间： 2019/10/15
 * 修改备注：
 */
@Service
public class PermissionUserServiceImpl implements IPermissionUserService {

    @Autowired
    IUserDetailsMapper userDetailsMapper;

    @Override
    public void addPermissionUser(UserDetailsImpl userDetails) {

        userDetailsMapper.addPermissionUser(userDetails);
    }
}
