package com.blog.wen.config;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 项目名称：permission-demo
 * 类名称：PasswordEncoderImpl
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/10/10
 * 修改人：yingx
 * 修改时间： 2019/10/10
 * 修改备注：
 */
@Component
public class PasswordEncoderImpl implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {

        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {

        return s.equals(charSequence);
    }
}
