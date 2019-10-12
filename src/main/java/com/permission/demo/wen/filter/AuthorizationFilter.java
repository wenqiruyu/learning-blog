package com.permission.demo.wen.filter;

import com.permission.demo.wen.entity.UserDetailImpl;
import com.permission.demo.wen.utils.Constants;
import com.permission.demo.wen.utils.TokenUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 项目名称：permission-demo
 * 类名称：AuthorizationFilter
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/10/11
 * 修改人：yingx
 * 修改时间： 2019/10/11
 * 修改备注：
 */
@Component
public class AuthorizationFilter extends OncePerRequestFilter {

    /*@Autowired
    @Qualifier("userDetailsService")*/
    private UserDetailsService userDetailsService;

    public AuthorizationFilter(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    /*public AuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }*/

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String header = httpServletRequest.getHeader(Constants.TOKEN_HEADER);
        if (StringUtils.isBlank(header)) {
            header = httpServletRequest.getParameter(Constants.TOKEN);
        }
        if (header != null && header.startsWith(Constants.TOKEN_PREFIX)) {
            String token = header.substring(Constants.TOKEN_PREFIX.length());
            String username = TokenUtils.getUsernameByToken(token);
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetailImpl userDetails = (UserDetailImpl) userDetailsService.loadUserByUsername(username);
                if (TokenUtils.validateUser(username, token, userDetails)) {
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities()
                    );
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
