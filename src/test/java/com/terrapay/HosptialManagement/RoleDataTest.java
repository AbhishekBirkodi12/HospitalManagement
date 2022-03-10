package com.terrapay.HosptialManagement;

import com.terrapay.HosptialManagement.dao.RoleDao;
import com.terrapay.HosptialManagement.entities.Role;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RoleDataTest {
    @Autowired
    private RoleDao roleDao;

    @Test
    @Order(1)
    public void testRoleCreate(){
        Role r1= new Role();
        r1.setRoleId(1);
        r1.setRoleName("ADMIN");
        roleDao.save(r1);
        assertNotNull(roleDao.findById(1).get());

        Role r2= new Role();
        r2.setRoleId(2);
        r2.setRoleName("DOCTOR");
        roleDao.save(r2);
        assertNotNull(roleDao.findById(2).get());


    }


    @Test
    @Order(2)
    public void testGetRole(){
        List<Role> list=roleDao.findAll();
        assertThat(list).size().isGreaterThan(1);

    }

}
