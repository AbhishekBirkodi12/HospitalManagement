package com.terrapay.HosptialManagement.response;

import java.util.HashMap;

public class ApiResponse {

    private Integer status;
    private boolean success;
    HashMap<Object, Object>result=new HashMap<Object, Object>();

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public HashMap<Object, Object> getResult() {
        return result;
    }

    public void setResult(HashMap<Object, Object> result) {
        this.result = result;
    }
}
