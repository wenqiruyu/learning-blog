package com.blog.wen.entity;

import java.util.List;

/**
 * 项目名称：learning-blog
 * 类名称：Menu
 * 类描述：系统菜单类
 * 创建人：yingx
 * 创建时间： 2019/10/14
 * 修改人：yingx
 * 修改时间： 2019/10/14
 * 修改备注：
 */
public class Menu {

    private Long id;

    /**
     * 链接
     */
    private String url;

    /**
     * 路径
     */
    private String path;

    /**
     * 成分
     */
    private String component;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单icon
     */
    private String iconCls;

    private Integer keepAlive;

    private Integer requireAuth;

    private Long parentId;

    private Integer enabled;

    /**
     * 菜单允许权限
     */
    private List<UserRole> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Integer getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(Integer keepAlive) {
        this.keepAlive = keepAlive;
    }

    public Integer getRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(Integer requireAuth) {
        this.requireAuth = requireAuth;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", path='" + path + '\'' +
                ", component='" + component + '\'' +
                ", name='" + name + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", keepAlive=" + keepAlive +
                ", requireAuth=" + requireAuth +
                ", parentId=" + parentId +
                ", enabled=" + enabled +
                ", roles=" + roles +
                '}';
    }
}
