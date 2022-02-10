package com.terrapay.HosptialManagement.service;

import com.terrapay.HosptialManagement.dao.RoleDao;
import com.terrapay.HosptialManagement.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleDao roleDao;

    public Role createRole(Role role) {
         return roleDao.save(role);
    }

    public List<Role> getRoles() {
        return roleDao.findAll();
    }
}
