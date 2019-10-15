package com.blog.wen.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.blog.wen.enums.ResultEnum;

import java.io.Serializable;

/**
 * 项目名称：permission-demo
 * 类名称：ResultVO
 * 类描述：返回格式类
 * 创建人：yingx
 * 创建时间： 2019/9/26
 * 修改人：yingx
 * 修改时间： 2019/9/26
 * 修改备注：
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL) // 保证json序列化的时候，如果是null对象，key也会消失
public class ResultVO<T> implements Serializable {

    /** 状态码*/
    private String status;

    /** 提示信息*/
    private String msg;

    /** 返回数据*/
    private T data;

    /**
     * 只返回错误码
     * @author yingx
     * @date 2019/9/26
     * @param status
     * @return
     */
    private ResultVO(String status) {
        this.status = status;
    }

    /**
     * 返回错误码和数据
     * @author yingx
     * @date 2019/9/26
     * @param status
     * @param data
     * @return
     */
    private ResultVO(String status, T data) {
        this.status = status;
        this.data = data;
    }

    /**
     * 返回错误码，错误提示和数据
     * @author yingx
     * @date 2019/9/26
     * @param status
     * @param msg
     * @param data
     * @return
     */
    private ResultVO(String status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 返回错误码、错误提示
     * @author yingx
     * @date 2019/9/26
     * @param status
     * @param msg
     * @return
     */
    private ResultVO(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    /**
     * 判断是否返回成功的提示码
     * @author yingx
     * @date 2019/9/26
     * @param
     * @return boolean
     */
    @JsonIgnore // 使之不再进行序列化
    public boolean isSuccess() {
        // 响应成功
        return this.status == ResultEnum.SUCCESS.getCode();
    }

    public static <T> ResultVO<T> createBySuccess() {
        return new ResultVO<T>(ResultEnum.SUCCESS.getCode());
    }

    public static <T> ResultVO<T> createBySuccess(T data) {
        return new ResultVO<T>(ResultEnum.SUCCESS.getCode(), "success", data);
    }

    public static <T> ResultVO<T> createBySuccess(String msg, T data) {
        return new ResultVO<T>(ResultEnum.SUCCESS.getCode(), msg, data);
    }

    public static <T> ResultVO<T> createBySuccessMessage(String msg) {
        return new ResultVO<T>(ResultEnum.SUCCESS.getCode(), msg);
    }

    public static <T> ResultVO<T> createByError() {
        return new ResultVO<T>(ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getMsg());
    }

    public static <T> ResultVO<T> createByErrorCodeMessage(String errorCode, String errorMessage) {
        return new ResultVO<T>(errorCode, errorMessage);
    }

    public static <T> ResultVO<T> createByErrorMessage(String errorMessage) {
        return new ResultVO<T>(ResultEnum.FAIL.getCode(), errorMessage);
    }

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
