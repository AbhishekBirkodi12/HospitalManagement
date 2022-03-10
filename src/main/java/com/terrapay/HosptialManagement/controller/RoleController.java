package com.terrapay.HosptialManagement.controller;

import com.terrapay.HosptialManagement.entities.Role;
import com.terrapay.HosptialManagement.response.ApiResponse;
import com.terrapay.HosptialManagement.response.StatusResponse;
import com.terrapay.HosptialManagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/createNewRole")
    public ApiResponse createNewRole(@Valid @RequestBody Role role, BindingResult result) {
        List<String> messages = new ArrayList<String>();
        if (result.hasErrors()) {
            for (ObjectError er : result.getAllErrors()) {
                messages.add(er.getDefaultMessage());
            }
            return StatusResponse.status_Failed(messages);
        }

         roleService.createRole(role);
        return StatusResponse.status_Ok("Role created Successfully");
    }

    @GetMapping("/getRoles")
    public List<Role> getRoles() {
        return roleService.getRoles();
    }
}
