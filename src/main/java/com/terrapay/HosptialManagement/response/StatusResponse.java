package com.terrapay.HosptialManagement.response;

import com.terrapay.HosptialManagement.entities.Department;
import com.terrapay.HosptialManagement.entities.UserMaster;
import org.apache.catalina.connector.Response;

public class StatusResponse {
    public static ApiResponse response;

    public static ApiResponse status_Ok(Object obj)
    {
        response=new ApiResponse();
        response.setSuccess(true);
        response.setStatus(Response.SC_OK);
        response.getResult().put("success", obj);
        return response;
    }

    public static ApiResponse status_Failed(Object message)
    {
        response=new ApiResponse();
        response.setSuccess(false);
        response.setStatus(Response.SC_INTERNAL_SERVER_ERROR);
        response.getResult().put("failed", message);
        return response;
    }

    public static ApiResponse userById(UserMaster userMaster)
    {
        response=new ApiResponse();
        response.setSuccess(true);
        response.setStatus(Response.SC_OK);
        response.getResult().put("user", userMaster);
        return response;
    }

    public static ApiResponse departmentById(Department department)
    {
        response=new ApiResponse();
        response.setSuccess(true);
        response.setStatus(Response.SC_OK);
        response.getResult().put("department", department);
        return response;
    }




}
