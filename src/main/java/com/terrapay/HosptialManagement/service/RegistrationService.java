package com.terrapay.HosptialManagement.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.terrapay.HosptialManagement.dao.RegistrationDao;
import com.terrapay.HosptialManagement.entities.UserMaster;
import com.terrapay.HosptialManagement.request.ChangePasswordRequest;
import com.terrapay.HosptialManagement.request.RegistrationRequest;

@Service
@Transactional
public class RegistrationService {

    @Autowired
    BCryptPasswordEncoder bcryptPasswordEncoder;

    @Autowired
    private RegistrationDao registrationDao;

    

    public boolean registerNewUser(RegistrationRequest userRegistration) throws Exception {
        boolean isValid = registrationValidation(userRegistration.getEmailAddress(), userRegistration.getPhoneNumber());
        if (isValid) {

            throw new Exception("User already exists");
        }

        try {
            UserMaster userMasterReg = new UserMaster();
            userMasterReg.setFirstName(userRegistration.getFirstName());
            userMasterReg.setMiddleName(userRegistration.getMiddleName());
            userMasterReg.setLastName(userRegistration.getLastName());
            userMasterReg.setEmailAddress(userRegistration.getEmailAddress());
            userMasterReg.setPhoneNumber(userRegistration.getPhoneNumber());
            userMasterReg.setAlternatePhoneNumber(userRegistration.getAlternatePhoneNumber());
            userMasterReg.setPassword(bcryptPasswordEncoder.encode(userRegistration.getPassword()));
            userMasterReg.setGender(userRegistration.getGender());
            userMasterReg.setRoleId(userRegistration.getRoleId());
            userMasterReg.setCreatedDate(new Date());
            userMasterReg.setActive(userRegistration.isActive());
            UserMaster userId = registrationDao.save(userMasterReg);
            userMasterReg.setCreatedBy(userId.getUserId());
            if (userRegistration.getRoleId() == 2) {
                userMasterReg.setDoctor(userRegistration.getDoctor());
                userMasterReg.getDoctor().setUserMaster(userMasterReg);
                userMasterReg.getDoctor().setCreatedDate(new Date());
                userMasterReg.getDoctor().setCreatedBy(userId.getUserId());

            }
            if (userRegistration.getRoleId() == 5){
                userMasterReg.setPatient(userRegistration.getPatient());
                userMasterReg.getPatient().setUserMaster(userMasterReg);
                userMasterReg.getPatient().setCreatedDate(new Date());
                userMasterReg.getPatient().setCreatedBy(userId.getUserId());
            }

            registrationDao.save(userMasterReg);
            return true;
        }  catch (Exception e) {
            System.out.println(e.getMessage());
            return false;

        }
    }


    public List<UserMaster> getUsers() {

        return registrationDao.getActiveUsers();
    }


    public UserMaster getUserByID(int id) {
        try {
            UserMaster user=registrationDao.findById(id).get();
        } catch (NoSuchElementException e) {
            return null;
        }
        return registrationDao.findById(id).get();


    }

    public UserMaster updateUser(int id, UserMaster master) {
        List<UserMaster>li= registrationDao.getUpdatedUser(master.getEmailAddress(),master.getPhoneNumber(),id);
        if (li.size()>=1){return null;}
        master.setUserId(id);
        String password=registrationDao.getPassword(id);
        master.setPassword(bcryptPasswordEncoder.encode((password)));
        master.setModifiedDate(new Date());
        master.setModifiedBy(master.getUserId());
        if (master.getRoleId()==2){
            master.getDoctor().setModifiedDate(new Date());
            master.getDoctor().setModifiedBy(master.getUserId());
        }
        if (master.getRoleId()==5){
            master.getPatient().setModifiedDate(new Date());
            master.getPatient().setModifiedBy(master.getUserId());
        }
        return  registrationDao.save(master);
    }


    public boolean deleteUser(int id) {

        try {
            registrationDao.setUseractive(false, id);

            // registrationDao.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean registrationValidation(String email, String phoneNumber) {
        return registrationDao.existsByEmailAddressAndPhoneNumber(email, phoneNumber);

    }

    public boolean changePassword(ChangePasswordRequest changePassword, int id) {

        try {

            String password = registrationDao.getPassword(id);
            if (bcryptPasswordEncoder.matches(changePassword.getOldPassword(), password)) {
                changePassword(changePassword.getNewPassword(), id);
                return true;
            }


            return false;
        } catch (Exception e) {

            return false;
        }


    }

    void changePassword(String password, int id) {
        registrationDao.changePassword(bcryptPasswordEncoder.encode(password), id);
    }
}

