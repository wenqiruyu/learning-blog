package com.blog.wen.controller;

import com.blog.wen.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 项目名称：permission-demo
 * 类名称：UserController
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/9/30
 * 修改人：yingx
 * 修改时间： 2019/9/30
 * 修改备注：
 */
@RestController
//@RequestMapping("/user")
public class UserController {

    @PostMapping("/register")
    public ResultVO registerUser(@RequestBody Map<String,String> registerUser){
        /*User user = new User();
        user.setUsername(registerUser.get("username"));
        // 记得注册的时候把密码加密一下
        user.setPassword(new BCryptPasswordEncoder().encode(registerUser.get("password")));
        user.setRole("ROLE_USER");
        userService.addUser(user);*/
        return ResultVO.createBySuccess();
    }

    @PostMapping("/emp/adv")
    public ResultVO empAdv(){
        /*User user = new User();
        user.setUsername(registerUser.get("username"));
        // 记得注册的时候把密码加密一下
        user.setPassword(new BCryptPasswordEncoder().encode(registerUser.get("password")));
        user.setRole("ROLE_USER");
        userService.addUser(user);*/
        return ResultVO.createBySuccess();
    }
}
