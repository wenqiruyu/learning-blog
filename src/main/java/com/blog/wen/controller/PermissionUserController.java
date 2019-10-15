package com.blog.wen.controller;

import com.blog.wen.entity.UserDetailsImpl;
import com.blog.wen.service.IPermissionUserService;
import com.blog.wen.service.impl.UserDetailServiceImpl;
import com.blog.wen.vo.LoginUserVO;
import com.blog.wen.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 项目名称：permission-demo
 * 类名称：PermissionUserController
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/9/30
 * 修改人：yingx
 * 修改时间： 2019/9/30
 * 修改备注：
 */
@RestController
@RequestMapping("/user")
public class PermissionUserController {

    @Autowired
    private IPermissionUserService permissionUserService;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @PostMapping("/register")
    public ResultVO registerUser(@RequestBody LoginUserVO loginUserVO){

        // 判断用户是否存在
        if (userDetailService.loadUserByUsername(loginUserVO.getUsername()) != null) {
            return ResultVO.createBySuccessMessage("用户名已存在！");
        }
        UserDetailsImpl userDetails = new UserDetailsImpl();
        userDetails.setUsername(loginUserVO.getUsername());
        // 对密码进行加密
        userDetails.setPassword(new BCryptPasswordEncoder().encode(loginUserVO.getPassword()));
        permissionUserService.addPermissionUser(userDetails);
        return ResultVO.createBySuccess("注册成功！");
    }
}
