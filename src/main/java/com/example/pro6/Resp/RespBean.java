package com.example.pro6.Resp;

public class RespBean<T> {

    private int status;
    private String msg;
    private T data;
    private int errorCode;

    public static RespBean build() {

        return new RespBean();
    }

    public static RespBean ok(String msg) {

        return new RespBean(0, 200, msg, null);
    }

    public static RespBean ok(String msg, Object data) {

        return new RespBean(0, 200, msg, data);
    }

    public static RespBean error(int error, String msg) {

        return new RespBean(error, 500, msg, null);
    }

    public static RespBean error(int error, String msg, Object data) {

        return new RespBean(error, 500, msg, data);
    }

    public static RespBean errorStatus(int error, int status, String msg, Object data) {

        return new RespBean(error, status, msg, data);
    }

    private RespBean() {

    }

    private RespBean(int error, int status, String msg, T data) {

        this.errorCode = error;
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public int getStatus() {

        return status;
    }

    public RespBean setStatus(int status) {

        this.status = status;
        return this;
    }

    public String getMsg() {

        return msg;
    }

    public RespBean setMsg(String msg) {

        this.msg = msg;
        return this;
    }

    public T getData() {

        return data;
    }

    public RespBean setData(T data) {

        this.data = data;
        return this;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
