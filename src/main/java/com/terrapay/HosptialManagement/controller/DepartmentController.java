package com.terrapay.HosptialManagement.controller;

import com.terrapay.HosptialManagement.entities.Department;
import com.terrapay.HosptialManagement.response.ApiResponse;
import com.terrapay.HosptialManagement.response.StatusResponse;
import com.terrapay.HosptialManagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/Department")
    public ApiResponse createNewDepartment(@Valid @RequestBody Department department, BindingResult result){
        List<String> messages = new ArrayList<String>();
        if (result.hasErrors()) {
            for (ObjectError er : result.getAllErrors()) {
                messages.add(er.getDefaultMessage());
            }
            return StatusResponse.status_Failed(messages);
        }


         departmentService.createNewDepartment(department);
        return StatusResponse.status_Ok("Department Created Succesfully");
    }
    @GetMapping("/Department")
    public List<Department> getDepartment(){
        return departmentService.getDepartment();
    }

    @GetMapping("/Department/{id}")
    public ApiResponse getDepartmentById(@PathVariable int id){

        Department dept=departmentService.getDepartmentById(id);
        if (dept==null){
            return StatusResponse.status_Failed("Department doesn't exists");
        }
        return StatusResponse.departmentById(dept);
    }

    @PutMapping("/Department/{id}")
    public ApiResponse updateDepartment(@PathVariable int id ,@RequestBody Department department){
        Department dept=departmentService.updateDepartment(id,department);

        return StatusResponse.departmentById(dept);
    }




}
