package com.blog.wen.utils;

/**
 * 项目名称：permission-demo
 * 类名称：Constants
 * 类描述：常量配置类
 * 创建人：yingx
 * 创建时间： 2019/9/26
 * 修改人：yingx
 * 修改时间： 2019/9/26
 * 修改备注：
 */
public class Constants {

    /** 存放Authorization的header字段*/
    public static final String TOKEN_HEADER = "Authorization";

    /** jwt生成的Token的head前缀*/
    public static final String TOKEN_PREFIX = "Bearer ";

    /** 密钥*/
    public static final String SECRET = "wenqiruyu";

    /** 荷载的公共声明（签发者）*/
    public static final String ISS = "yingx";

    /** 有效期，正常为一个小时*/
    public static final long EXPIRATION = 60*60*1000L;

    /** 记住我设为七天*/
    public static final long EXPIRATION_REMEMBER = 7*24*60*60*1000L;

    /** token的标识*/
    public static final String TOKEN= "token";

    /** token的标识*/
    public static final String X_ACCESS_TOKEN = "x-access-token";
}
