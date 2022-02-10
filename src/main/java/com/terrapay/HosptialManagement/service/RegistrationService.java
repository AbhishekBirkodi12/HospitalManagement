package com.terrapay.HosptialManagement.service;

import com.terrapay.HosptialManagement.dao.DoctorDao;
import com.terrapay.HosptialManagement.dao.RegistrationDao;
import com.terrapay.HosptialManagement.entities.Registration;
import com.terrapay.HosptialManagement.request.RegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationDao registrationDao;

    @Autowired
    private DoctorDao doctorDao;

    public boolean registerNewUser(RegistrationRequest userRegistration) {



        try {
                Registration userMasterReg = new Registration();
                userMasterReg.setFirstName(userRegistration.getFirstName());
                userMasterReg.setMiddleName(userRegistration.getMiddleName());
                userMasterReg.setLastName(userRegistration.getLastName());
                userMasterReg.setEmailAddress(userRegistration.getEmail());
                userMasterReg.setPhoneNumber(userRegistration.getPhoneNumber());
                userMasterReg.setAlternatePhoneNumber(userRegistration.getAlternatePhoneNumber());
                userMasterReg.setPassword(userRegistration.getPassword());
                userMasterReg.setGender(userRegistration.getGender());
                userMasterReg.setRoleId(userRegistration.getRoleId());
                userMasterReg.setCreatedDate(new Date());
                userMasterReg.setActive(true);
            if (userRegistration.getRoleId()==2) {

                userMasterReg.setDoctorInfo(userRegistration.getDoctorInfo());
                userMasterReg.getDoctorInfo().setRegistration(userMasterReg);

            }
            Registration userId= registrationDao.save(userMasterReg);
            userMasterReg.setCreatedBy(userId.getUserId());
            registrationDao.save(userMasterReg);



            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;

        }
    }


    public List<Registration> getUsers() {

        return registrationDao.findAll();
    }


    public Registration getUserByID(int id) {
        return registrationDao.findById(id).get();
    }

    public Registration updateUser(int id, Registration master) {
        Registration umaster = registrationDao.findById(id).get();
        umaster.setFirstName(master.getFirstName());
        umaster.setMiddleName(master.getMiddleName());
        umaster.setLastName(master.getLastName());
        umaster.setEmailAddress(master.getEmailAddress());
        umaster.setPassword(master.getPassword());
        umaster.setPhoneNumber(master.getPhoneNumber());
        umaster.setAlternatePhoneNumber(master.getAlternatePhoneNumber());
        umaster.setActive(master.isActive());
        umaster.setModifiedDate(new Date());
        umaster.setModifiedBy(umaster.getUserId());
        return registrationDao.save(umaster);
    }


    public boolean deleteUser(int id) {
        try {
            registrationDao.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

