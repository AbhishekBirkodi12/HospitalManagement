package com.terrapay.HosptialManagement.service;

import com.terrapay.HosptialManagement.dao.DepartmentDao;
import com.terrapay.HosptialManagement.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DepartmentService {
    @Autowired
    DepartmentDao departmentDao;

    public Department createNewDepartment(Department department) {
        department.setCreatedDate(new Date());
        return departmentDao.save(department);
    }

    public List<Department> getDepartment() {
        return (List<Department>) departmentDao.findAll();
    }

    public Department getDepartmentById(int id) {
        try {
            Department department = departmentDao.findById(id).get();
        } catch (NoSuchElementException e) {

            return null;
        }

        return departmentDao.findById(id).get();
    }


    public Department updateDepartment(int id, Department department) {

        Department dep = departmentDao.findById(id).get();
        dep.setDepId(id);
        dep.setDepName(department.getDepName());
        dep.setModifiedDate(new Date());
        return departmentDao.save(dep);
    }


}
