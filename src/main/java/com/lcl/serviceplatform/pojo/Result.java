package com.lcl.serviceplatform.pojo;

public class Result {
    private boolean success;
    private String msg;
    private Object data;
    private int maxInactive;

    public Result() {
        this.success = true;
    }
    public Result(int maxInactive) {
        this.success = true;
        this.maxInactive = maxInactive;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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

    public int getMaxInactive() {
        return maxInactive;
    }

    public void setMaxInactive(int maxInactive) {
        this.maxInactive = maxInactive;
    }
}
