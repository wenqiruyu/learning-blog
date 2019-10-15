package com.permission.demo.wen.service.impl;

import com.permission.demo.wen.entity.User;
import com.permission.demo.wen.entity.UserDetailsImpl;
import com.permission.demo.wen.mapper.IUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private IUserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetailsImpl userByName = userMapper.getUserByName(username);
        if(userByName == null){
            throw new UsernameNotFoundException("用户不存在哦");
        }
        return userByName;
    }
}
