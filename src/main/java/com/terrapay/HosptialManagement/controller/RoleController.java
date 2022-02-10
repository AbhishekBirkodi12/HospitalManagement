package com.terrapay.HosptialManagement.controller;

import com.terrapay.HosptialManagement.entities.Role;
import com.terrapay.HosptialManagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/createNewRole")
    public Role createNewRole(@RequestBody Role role) {
         return roleService.createRole(role);
    }

    @GetMapping("/getRoles")
    public List<Role> getRoles() {
        return roleService.getRoles();
    }
}
