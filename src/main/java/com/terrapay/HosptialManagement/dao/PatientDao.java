package com.terrapay.HosptialManagement.dao;

import com.terrapay.HosptialManagement.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientDao extends JpaRepository<Patient,Integer> {
}
