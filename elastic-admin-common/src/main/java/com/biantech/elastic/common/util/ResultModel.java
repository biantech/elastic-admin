package com.biantech.elastic.common.util;

/**
 * @Author jonathan
 * @Date 2016/10/8/13:40
 * @Description
 */
public class ResultModel {
    private int code;
    private String msg;
    private Object data = "";


    public ResultModel(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultModel(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultModel() {
    }

    public static ResultModel instance(int code, String msg) {
        return new ResultModel(code, msg);
    }

    public static ResultModel success() {
        return new ResultModel(ResponseCode.success.getCode(), ResponseCode.success.getMsg());
    }

    public static ResultModel success(Object data) {
        return new ResultModel(ResponseCode.success.getCode(), ResponseCode.success.getMsg(), data);
    }

    public static ResultModel error() {
        return new ResultModel(ResponseCode.error.getCode(), ResponseCode.error.getMsg());
    }

    public static ResultModel error(String msg) {
        return new ResultModel(ResponseCode.error.getCode(), msg);
    }

    @Override
    public String toString() {
        return "ResultModel{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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
}
