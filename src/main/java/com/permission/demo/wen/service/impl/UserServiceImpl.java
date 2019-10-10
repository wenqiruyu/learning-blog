package com.permission.demo.wen.service.impl;

import com.permission.demo.wen.mapper.IUserMapper;
import com.permission.demo.wen.entity.User;
import com.permission.demo.wen.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目名称：permission-demo
 * 类名称：UserServiceImpl
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/9/30
 * 修改人：yingx
 * 修改时间： 2019/9/30
 * 修改备注：
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper userDao;

    @Override
    public List<User> getUser() {

        List<User> user = userDao.getUser();
        return user;
    }

    @Override
    public int addUser(User user) {

        userDao.addUser(user);
        return 0;
    }
}
