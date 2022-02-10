package com.terrapay.HosptialManagement.dao;

import com.terrapay.HosptialManagement.entities.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegistrationDao extends JpaRepository<Registration, Integer> {

    @Query(value = "SELECT * from registration, doctor_info where registration.user_id=doctor_info.user_id", nativeQuery=true)
    List<Registration>getDoctors();

}
