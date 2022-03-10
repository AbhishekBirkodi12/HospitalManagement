package com.terrapay.HosptialManagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.terrapay.HosptialManagement.entities.Doctor;


public interface DoctorDao extends JpaRepository<Doctor,Integer> {
	
	@Query(value = "select distinct user_master.user_id,first_name,last_name,email_address,phone_number,dep_name,fees from user_master,department,doctor,treatment where user_master.user_id=doctor.user_id and doctor.department_id=department.dep_id and role_id=2",nativeQuery = true)
	List<Object> getDoctorInfo();
	
	
}
