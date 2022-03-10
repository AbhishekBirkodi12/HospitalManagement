package com.terrapay.HosptialManagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.terrapay.HosptialManagement.entities.Treatment;

public interface TreatmentDao extends JpaRepository<Treatment, Integer> {
	
	 @Query(value = "select distinct concat(d.first_name,' ',d.last_name) as doctor_name,concat(p.first_name,' ',p.last_name) as patient_name,disease,treatment_description,EXTRACT(DAY FROM MAX(treatment_end_date)-MIN(treatment_start_date)) as days,fees,treatment_start_date,treatment_end_date from user_master as d,user_master as p,treatment,doctor where d.role_id=2 and p.role_id=5 and d.user_id=treatment.user_id and p.user_id=treatment.patient_id and d.user_id=doctor.user_id group by d.first_name,p.first_name,disease,treatment_description,fees,treatment_start_date,treatment_end_date,d.last_name,p.last_name",nativeQuery = true)
	    List<Object> getTreatmentInfo();
	 
	 @Query("select count(*) from Treatment where userId=:userId")
		int patientTreated(@Param("userId") int userId);
}
