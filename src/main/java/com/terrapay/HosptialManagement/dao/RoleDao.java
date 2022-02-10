package com.terrapay.HosptialManagement.dao;

import com.terrapay.HosptialManagement.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Integer> {
}
