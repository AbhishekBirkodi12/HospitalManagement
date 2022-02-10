package com.terrapay.HosptialManagement.dao;

import com.terrapay.HosptialManagement.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DoctorDao extends JpaRepository<Doctor,Integer> {
}
