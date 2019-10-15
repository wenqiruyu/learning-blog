package com.permission.demo.wen.config;

import com.alibaba.fastjson.JSON;
import com.permission.demo.wen.enums.ResultEnum;
import com.permission.demo.wen.vo.ResultVO;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: zzx
 * @date: 2018/10/15 15:04
 * @description: 用户未登录时返回给前端的数据
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.getWriter().write(JSON.toJSONString(ResultVO.createBySuccess(ResultEnum.USER_NEED_AUTHORITIES)));
    }
}
