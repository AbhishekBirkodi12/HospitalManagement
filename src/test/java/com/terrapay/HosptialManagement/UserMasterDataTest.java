package com.terrapay.HosptialManagement;

import com.terrapay.HosptialManagement.dao.RegistrationDao;
import com.terrapay.HosptialManagement.entities.Doctor;
import com.terrapay.HosptialManagement.entities.Patient;
import com.terrapay.HosptialManagement.entities.UserMaster;
import com.terrapay.HosptialManagement.request.ChangePasswordRequest;
import com.terrapay.HosptialManagement.request.RegistrationRequest;
import com.terrapay.HosptialManagement.service.RegistrationService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserMasterDataTest {
    @Autowired
    RegistrationDao registrationDao;

    @Autowired
    RegistrationService registrationService;

    @Test
    @Order(1)
    public void testCreateUserPatient() throws Exception {
        RegistrationRequest u=new RegistrationRequest();
        Patient p=new Patient();
        u.setPatient(p);
        p.setDisease("Eye pain");
        p.setCreatedBy(1);
        p.setCreatedDate(new Date());

        u.setUserId(1);
        u.setFirstName("Virat");
        u.setMiddleName("S");
        u.setLastName("Kohli");
        u.setPhoneNumber("98765544");
        u.setAlternatePhoneNumber("86544467");
        u.setEmailAddress("virat@gmail.com");
        u.setPassword("virat@pass");
        u.setActive(true);
        u.setGender("Male");
        u.setRoleId(5);

        registrationService.registerNewUser(u);

        assertNotNull(registrationDao.findById(1).get());

    }
    @Test
    @Order(2)
    public void testCreateUserDoctor() throws Exception {
        RegistrationRequest u=new RegistrationRequest();
        Doctor d=new Doctor();
        u.setDoctor(d);
        d.setFees(500);
        d.setCreatedDate(new Date());
        d.setCreatedBy(1);

        u.setUserId(2);
        u.setFirstName("Mahendra");
        u.setMiddleName("Singh");
        u.setLastName("Dhoni");
        u.setPhoneNumber("981234");
        u.setAlternatePhoneNumber("7584753");
        u.setEmailAddress("mahendra@gmail.com");
        u.setPassword("mahi@pass");
        u.setActive(true);
        u.setGender("Male");
        u.setRoleId(2);

        registrationService.registerNewUser(u);

    }

    @Test
    @Order(3)
    public void testChangePassword(){
        ChangePasswordRequest c=new ChangePasswordRequest();
        c.setOldPassword("virat@pass");
        c.setNewPassword("v@pass");
        c.setConfirmPassword("v@pass");
        assertEquals(true, registrationService.changePassword(c,1));
    }

    @Test
    @Order(4)
    public void testGetAllUsers(){
        List<UserMaster> list=registrationDao.findAll();
        assertThat(list).size().isGreaterThan(0);
    }

    @Test
    @Order(5)
    public void testGetUserById(){
        UserMaster userMaster=registrationDao.findById(1).get();
        assertEquals("Virat", userMaster.getFirstName());
        assertEquals("Kohli",userMaster.getLastName());
    }



    @Test
    @Order(6)
    public void testGetUserByIdFalse(){
        UserMaster userMaster=registrationDao.findById(1).get();
        assertNotEquals("Vira", userMaster.getFirstName());
        assertNotEquals("Kohl",userMaster.getLastName());
    }

    @Test
    @Order(7)
    public void testUpdateUser(){
        UserMaster userMaster= registrationDao.findById(1).get();
        userMaster.setFirstName("Virat");
        userMaster.setMiddleName("S");
        userMaster.setLastName("Kohli");
        userMaster.setGender("Male");
        userMaster.setActive(true);
        userMaster.setRoleId(3);
        userMaster.setEmailAddress("virat123@gmail.com");
        userMaster.setPassword("virat@pass");
        userMaster.setPhoneNumber("98765544");
        userMaster.setAlternatePhoneNumber("86544467");
        userMaster.setModifiedBy(1);
        userMaster.setModifiedDate(new Date());
        registrationDao.save(userMaster);
        assertEquals("virat123@gmail.com",userMaster.getEmailAddress());

    }

    @Test
    @Order(8)
    public void testUpdateUserFalse(){
        UserMaster userMaster= registrationDao.findById(1).get();
        userMaster.setFirstName("Virat");
        userMaster.setMiddleName("Sa");
        userMaster.setLastName("Kohli");
        userMaster.setGender("Male");
        userMaster.setActive(true);
        userMaster.setRoleId(3);
        userMaster.setEmailAddress("virat123@gmail.com");
        userMaster.setPassword("virat@pass");
        userMaster.setPhoneNumber("98765544");
        userMaster.setAlternatePhoneNumber("86544467");
        userMaster.setModifiedBy(1);
        userMaster.setModifiedDate(new Date());
        registrationDao.save(userMaster);
        assertNotEquals("virat@gmail.com",userMaster.getEmailAddress());
    }

    @Test
    @Order(9)
    public void deleteUser(){



        registrationService.deleteUser(1);
        UserMaster u=registrationDao.findById(1).get();
        assertEquals(false, u.isActive());


    }


}
