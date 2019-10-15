package com.blog.wen.mapper;

import com.blog.wen.entity.UserDetailsImpl;

/**
 * 项目名称：permission-demo
 * 类名称：IUserDetailsMapper
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/9/30
 * 修改人：yingx
 * 修改时间： 2019/9/30
 * 修改备注：
 */
public interface IUserDetailsMapper {

    UserDetailsImpl getUserByName(String username);

    void addPermissionUser(UserDetailsImpl userDetails);
}
