package com.permission.demo.wen.utils;

import java.util.UUID;

/**
 * 项目名称：permission-demo
 * 类名称：UUIDUtils
 * 类描述：UUID工具类
 * 创建人：yingx
 * 创建时间： 2019/9/26
 * 修改人：yingx
 * 修改时间： 2019/9/26
 * 修改备注：
 */
public class UUIDUtils {

    public static String getUUID() {
        return UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");
    }
}
