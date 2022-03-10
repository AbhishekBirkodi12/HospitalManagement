package com.terrapay.HosptialManagement;

import com.terrapay.HosptialManagement.dao.DepartmentDao;
import com.terrapay.HosptialManagement.entities.Department;
import com.terrapay.HosptialManagement.entities.Role;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DepartmentDataTest {

    @Autowired
    private DepartmentDao departmentDao;


    @Test
    @Order(1)
    public void testCreateDepartment(){
        Department department=new Department();
        department.setDepName("OPTHOLOGY");
        department.setDepId(1);
        departmentDao.save(department);
        assertNotNull(departmentDao.findById(1).get());

        Department department2=new Department();
        department2.setDepName("CARDIOLOGY");
        department2.setDepId(2);
        departmentDao.save(department2);
        assertNotNull(departmentDao.findById(2).get());

        Department department3=new Department();
        department3.setDepName("ONCOLOGY");
        department3.setDepId(3);
        departmentDao.save(department3);
        assertNotNull(departmentDao.findById(3).get());

    }

    @Test
    @Order(2)
    public void testGetDepartment(){
        List<Department> list=departmentDao.findAll();
        assertThat(list).size().isGreaterThan(1);
    }

    @Test
    @Order(3)
    public void testGetDepartmentById(){
        Department department=departmentDao.findById(1).get();
        assertEquals("OPTHOLOGY",department.getDepName());

        Department department2=departmentDao.findById(2).get();
        assertEquals("CARDIOLOGY",department2.getDepName());
    }

    @Test
    @Order(4)
    public void testGetDepartmentByIdFalse(){
        Department department= departmentDao.findById(1).get();
        assertNotEquals("OPTHO",department.getDepName());
    }

    @Test
    @Order(5)
    public void testUpdateFalse(){
        Department department= departmentDao.findById(1).get();
        department.setDepName("OPTHOLOGY1");
        departmentDao.save(department);
        assertNotEquals("OPTHO",departmentDao.findById(1).get().getDepName());
    }
    @Test
    @Order(6)
    public void testUpdate(){
        Department department= departmentDao.findById(1).get();
        department.setDepName("OPTHOLOGY1");
        departmentDao.save(department);
        assertEquals("OPTHOLOGY1",departmentDao.findById(1).get().getDepName());
    }

    }




