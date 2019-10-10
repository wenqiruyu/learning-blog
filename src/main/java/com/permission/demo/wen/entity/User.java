package com.permission.demo.wen.entity;

import lombok.Data;

/**
 * 项目名称：permission-demo
 * 类名称：User
 * 类描述：用户类
 * 创建人：yingx
 * 创建时间： 2019/9/30
 * 修改人：yingx
 * 修改时间： 2019/9/30
 * 修改备注：
 */
@Data
public class User {

    /** 编号id*/
    private Long id;

    /** 用户名*/
    private String username;

    /** 密码*/
    private String password;

    /** 权限*/
    private String role;

    public String getUsername() {
        return username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
