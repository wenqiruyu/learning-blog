package com.blog.wen.filter;

import com.blog.wen.entity.Menu;
import com.blog.wen.entity.UserRole;
import com.blog.wen.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * 项目名称：learning-blog
 * 类名称：FilterInvocationSecurityMetadataSourceImpl
 * 类描述：根据请求地址获取当前地址的访问用户
 * 创建人：yingx
 * 创建时间： 2019/10/14
 * 修改人：yingx
 * 修改时间： 2019/10/14
 * 修改备注：
 */
@Component
public class FilterInvocationSecurityMetadataSourceImpl implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private IMenuService menuService;

    // 用于进行路径的匹配规则
    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {

        // 获取请求地址
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        // 排除登录地址
        if("/login".equals(requestUrl)){
            return null;
        }
        // 获取全部访问地址
        List<Menu> allMenu = menuService.getAllMenu();
        for(Menu menu : allMenu){
            if(antPathMatcher.match(requestUrl, menu.getUrl()) && menu.getRoles().size() > 0){
                List<UserRole> roleList = menu.getRoles();
                String[] role = new String[roleList.size()];
                for(int i = 0; i < roleList.size(); i++ ){
                    role[i] = roleList.get(i).getRoleName();
                }
                return SecurityConfig.createList(role);
            }
        }
        // 该路径没有匹配的菜单路径,设置为登录权限
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}