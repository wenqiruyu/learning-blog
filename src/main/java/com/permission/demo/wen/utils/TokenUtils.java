package com.permission.demo.wen.utils;

import com.permission.demo.wen.entity.User;
import com.permission.demo.wen.entity.UserDetailImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * 项目名称：permission-demo
 * 类名称：TokenUtils
 * 类描述：Token工具类
 * 创建人：yingx
 * 创建时间： 2019/9/26
 * 修改人：yingx
 * 修改时间： 2019/9/26
 * 修改备注：后续使用了spring security需要进行更改，使用UserDetail
 */
public class TokenUtils {

    /**
     * 获取Token
     *
     * @param username   用户名
     * @param isRemember 是否记住我 默认否
     * @return java.lang.String
     * @author yingx
     * @date 2019/9/26
     */
    public static String getToken(String username, boolean isRemember) {

        // 有效期
        Long expiration = isRemember ? Constants.EXPIRATION_REMEMBER : Constants.EXPIRATION;
        String token = Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, Constants.SECRET)
                .setIssuer(Constants.ISS)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .compact();
        return token;
    }

    /**
     * 根据token获取token中用户名
     *
     * @param token 用户token
     * @return java.lang.String
     * @author yingx
     * @date 2019/9/26
     */
    public static String getUsernameByToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(Constants.SECRET).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    /**
     * 判断用户的token是否过期
     *
     * @param token 用户token
     * @return boolean
     * @author yingx
     * @date 2019/9/26
     */
    public static boolean isExpiration(String token) {
        Claims claims = Jwts.parser().setSigningKey(Constants.SECRET).parseClaimsJws(token).getBody();
        return claims.getExpiration().after(new Date());
    }

    /**
     * 验证用户的token是否有效
     *
     * @param username
     * @param token
     * @return boolean
     * @author yingx
     * @date 2019/9/26
     */
    public static boolean validateToken(String username, String token) {
        String usernameByToken = getUsernameByToken(token);
        boolean result = usernameByToken.equals(username);
        return result;
    }

    /**
     * 验证用户（数据库）及 token是否有效
     *
     * @param username 用户名
     * @param token    用户token
     * @param user     数据库用户
     * @return boolean
     * @author yingx
     * @date 2019/9/26
     */
    public static boolean validateUser(String username, String token, UserDetailImpl user) {
        boolean result = username.equals(user.getUsername()) && isExpiration(token);
        return result;
    }

    private static Claims getTokenBody(String token) {
        return Jwts.parser()
                .setSigningKey(Constants.SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

    public static String getUserRole(String token) {
        return (String) getTokenBody(token).get("rol");
    }
}
