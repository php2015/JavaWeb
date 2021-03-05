package com.kestrelcjx.common.utils;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * JSON返回类
 */
public class JsonResult implements Serializable {
    /**
     * 错误码
     */
    private Integer code = 0;
    /**
     * 提示语
     */
    private String msg = "操作成功";
    /**
     * 返回对象
     */
    private Object data;
    /**
     * 数据总数
     */
    private Long count;

    public JsonResult() {
    }

    public JsonResult(String msg) {
        this.msg = msg;
    }

    public JsonResult(Object data) {
        this.data = data;
    }

    public JsonResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public JsonResult(Integer code, String msg, Object data, Long count) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.count = count;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public static JsonResult success() {
        return new JsonResult();
    }

    public static JsonResult success(String msg) {
        return new JsonResult(msg);
    }

    public static JsonResult success(Object data) {
        return new JsonResult(data);
    }

    public static JsonResult success(String msg, Object data) {
        return new JsonResult(0, msg, data);
    }

    public static JsonResult success(String msg, Object data, long count) {
        return new JsonResult(0, msg, data, count);
    }

    public static JsonResult error() {
        return new JsonResult(-1, "操作失败");
    }

    public static JsonResult error(String msg) {
        return new JsonResult(401, msg);
    }

    public static JsonResult error(Integer code, String msg) {
        return new JsonResult(code, msg);
    }

    public static JsonResult error(Integer code, String msg, Object data) {
        return new JsonResult(code, msg, data);
    }

    public static JsonResult error(ErrorCode errorCode) {
        return new JsonResult(errorCode.getCode(), errorCode.getMsg());
    }

    public static JsonResult error(HttpStatus httpStatus, String msg, Object data) {
        return new JsonResult(httpStatus.value(), msg, data);
    }

    public Object error(HttpStatus httpStatus, String msg) {
        this.code = httpStatus.value();
        this.msg = msg;
        return this;
    }
}
