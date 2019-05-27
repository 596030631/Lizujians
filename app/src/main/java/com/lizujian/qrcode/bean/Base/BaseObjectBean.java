package com.lizujian.qrcode.bean.Base;

public class BaseObjectBean<T>{
    /**
     * status : 1
     * msg : 获取成功
     * result : {} 对象
     */
    private int errorCode;
    private String errorMsg;
    private T result;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return errorMsg;
    }

    public void setMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
