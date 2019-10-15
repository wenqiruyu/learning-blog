package com.permission.demo.wen.enums;

/**
 * 项目名称：permission-demo
 * 类名称：ResultEnum
 * 类描述：返回枚举类
 * 创建人：yingx
 * 创建时间： 2019/9/26
 * 修改人：yingx
 * 修改时间： 2019/9/26
 * 修改备注：
 */
public enum ResultEnum {

    /** 系统级错误代码定义，长度统一为3位,包括常见框架请求响应编码*/
    SUCCESS("200", "成功"),
    FAIL("400", "失败"),
    INVALID_AUTHCODE("401", "未授权"),
    SYS_ERROR("402", "系统错误"),
    PARAMS_ERROR("403", "参数错误 "),

    /** 业务级错误代码定义 ，1开头代表用户账号错误,长度统一为4位*/
    UNKNOWN_USER("1001", "账号不存在或密码错误"),
    NAME_OR_PASS_EMPTY("1002", "账号或密码不能为空"),
    USER_NOT_EXISTED("1003", "用戶不存在"),
    NO_USE("1004", "账号已冻结,请联系管理员"),
    USER_ACCOUNT_IS_EXP("1005", "账号已过期"),
    USER_ACCOUNT_IS_ENABLED("1006", "账号已被禁用"),
    USER_LOGOUT_SUCCESS("1007", "用户注销成功"),
    ACCOUNT_HAS_NOT_EXISTED("1008", "账号添加失败，请确认输入！"),
    TYPE_NO_VALID("1009", "账户类型无效"),
    USER_ACCOUNT_IS_LOCK("1010", "账号已被锁定"),
    ACCOUNT_HAS_EXIST("1011", "账号已存在,请重新输入"),
    PASSWORD_WAS_INCORRECT("1012", "旧密码不正确"),
    PASSWORD_TWICE_WAS_INCORRECT("1013", "两次输入的密码不正确"),
    USER_NEED_AUTHORITIES("1014", "用户未登录"),
    USER_NO_ACCESS("1015", "用户无权访问"),

    /** 业务级错误代码定义,2开头代表Token相关校验错误*/
    TOKEN_FAIL("2001", "token无效"),
    TOKEN_SUCCESS("2000", "token合法"),
    TOKEN_IS_EXPIRES("2002", "token已过期,请重新申请"),
    TOKEN_IS_BLACK("2003", "该token为黑名单"),

    /** 角色相关的代码定义*/
    ROLE_HAS_EXIST("3001", "角色名已存在,请重新输入"),
    ROLE_NOT_EXIST("3002", "角色名不存在,请重新输入");
    private String code;
    private String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    /**
     * 根据code返回枚举值
     * @author yingx
     * @date 2019/9/26
     * @param code
     * @return com.permission.wen.enums.ResultEnum
     */
    public static ResultEnum parse(String code){
        ResultEnum[] values = values();
        for (ResultEnum value : values) {
            if(code.equals(value.getCode())){
                return value;
            }
        }
        throw  new RuntimeException("该code的枚举值不存在");
    }
}