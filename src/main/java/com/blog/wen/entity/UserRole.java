package com.blog.wen.entity;

/**
 * 项目名称：learning-blog
 * 类名称：UserRole
 * 类描述：用户权限表
 * 创建人：yingx
 * 创建时间： 2019/10/14
 * 修改人：yingx
 * 修改时间： 2019/10/14
 * 修改备注：
 */
public class UserRole {

    private Long id;

    /**
     * 用户权限名
     */
    private String roleName;

    /**
     * 权限中文名
     */
    private String nameZh;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", nameZh='" + nameZh + '\'' +
                '}';
    }
}
