package com.terrapay.HosptialManagement.controller;

import com.terrapay.HosptialManagement.entities.Department;
import com.terrapay.HosptialManagement.response.ApiResponse;
import com.terrapay.HosptialManagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/createNewDepartment")
    public Department createNewDepartment(@RequestBody Department department){
        return departmentService.createNewDepartment(department);
    }
    @GetMapping("/getDepartment")
    public List<Department> getDepartment(){
        return departmentService.getDepartment();
    }

    @GetMapping("/getDepartment/{id}")
    public Department getDepartmentById(@PathVariable int id){
        return departmentService.getDepartmentById(id);
    }

    @PutMapping("/updateDepartment/{id}")
    public Department updateDepartment(@PathVariable int id ,@RequestBody Department department){
        return departmentService.updateDepartment(id, department);
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public ApiResponse deleteDepartment(@PathVariable int id){
        ApiResponse response =new ApiResponse();
       boolean isSuccess = departmentService.deleteDepartment(id);

        if (isSuccess){
            response.setSuccess(true);
            response.setStatus("success");
            response.getResult().put("success", "Deleted successfully");
        }else {
            response.setSuccess(false);
            response.setStatus("failed");
            response.getResult().put("failed", "something went wrong");
        }
        return response;
    }


}
