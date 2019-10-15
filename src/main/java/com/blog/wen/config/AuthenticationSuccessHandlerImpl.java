package com.permission.demo.wen.config;

import com.alibaba.fastjson.JSON;
import com.permission.demo.wen.entity.UserDetailsImpl;
import com.permission.demo.wen.utils.TokenUtils;
import com.permission.demo.wen.vo.ResultVO;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: zzx
 * @date: 2018/10/15 16:12
 * @description: 用户登录成功时返回给前端的数据
 */
@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String jwtToken = TokenUtils.getToken(userDetails.getUsername(), false);

        httpServletResponse.getWriter().write(JSON.toJSONString(ResultVO.createBySuccess(jwtToken)));
    }
}
