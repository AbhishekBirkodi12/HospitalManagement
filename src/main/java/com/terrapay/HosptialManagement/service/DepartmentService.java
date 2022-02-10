package com.terrapay.HosptialManagement.service;

import com.terrapay.HosptialManagement.dao.DepartmentDao;
import com.terrapay.HosptialManagement.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentDao departmentDao;
    public Department createNewDepartment(Department department) {
        return departmentDao.save(department);
    }

    public List<Department> getDepartment() {
        return (List<Department>) departmentDao.findAll();
    }

    public Department getDepartmentById(int id) {
        return departmentDao.findById(id).get();
    }


    public Department updateDepartment(int id, Department department) {

        Department dep=departmentDao.findById(id).get();


        dep.setDepId(id);
        dep.setDepName(department.getDepName());
        return departmentDao.save(dep);
    }


    public boolean deleteDepartment(int id) {
        try {
            departmentDao.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
