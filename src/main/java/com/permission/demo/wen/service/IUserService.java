package com.permission.demo.wen.service;

import com.permission.demo.wen.entity.User;

import java.util.List;

/**
 * 项目名称：permission-demo
 * 类名称：IUserService
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/9/30
 * 修改人：yingx
 * 修改时间： 2019/9/30
 * 修改备注：
 */
public interface IUserService {

    List<User> getUser();

    int addUser(User user);
}
