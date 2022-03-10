package com.terrapay.HosptialManagement.service;

import com.terrapay.HosptialManagement.dao.RoleDao;
import com.terrapay.HosptialManagement.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleDao roleDao;

    public Role createRole(Role role) {
        Role r=new Role();
        r.setRoleName(role.getRoleName());
        r.setCreatedDate(new Date());
        return roleDao.save(r);
    }

    public List<Role> getRoles() {
        return roleDao.findAll();
    }
}
