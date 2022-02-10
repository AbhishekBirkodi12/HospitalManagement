package com.terrapay.HosptialManagement.dao;

import com.terrapay.HosptialManagement.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDao extends JpaRepository<Department, Integer> {
}
