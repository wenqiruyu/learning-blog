package com.permission.demo.wen.service.impl;

import com.permission.demo.wen.entity.User;
import com.permission.demo.wen.entity.UserDetailImpl;
import com.permission.demo.wen.mapper.IUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 项目名称：permission-demo
 * 类名称：UserDetailServiceImpl
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/10/10
 * 修改人：yingx
 * 修改时间： 2019/10/10
 * 修改备注：
 */
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private IUserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User userByName = userMapper.getUserByName(s);
        if(userByName == null){
            throw new UsernameNotFoundException("用户不存在哦");
        }
        return new UserDetailImpl(userByName);
    }
}
