package com.blog.wen.vo;

/**
 * 项目名称：permission-demo
 * 类名称：LoginUserVO
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/10/10
 * 修改人：yingx
 * 修改时间： 2019/10/10
 * 修改备注：
 */
public class LoginUserVO {

    /** 用户名*/
    private String username;

    /** 密码*/
    private String password;

    public String getUsername() {
        return username;
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

    @Override
    public String toString() {
        return "LoginUserVO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
