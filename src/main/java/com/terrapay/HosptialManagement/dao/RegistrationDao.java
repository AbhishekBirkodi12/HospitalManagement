package com.terrapay.HosptialManagement.dao;

import com.terrapay.HosptialManagement.entities.UserMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegistrationDao extends JpaRepository<UserMaster, Integer> {

    @Query(value = "SELECT * from user_master where is_active=true", nativeQuery=true)
    List<UserMaster>getActiveUsers();

    boolean existsByEmailAddressAndPhoneNumber(String email, String phoneNumber);

    @Query(value = "SELECT * from user_master where email_address=:email and phone_number=:phoneNumber and user_id!=:id", nativeQuery=true)
    List<UserMaster>getUpdatedUser(@Param("email") String email, @Param("phoneNumber") String phoneNumber,@Param("id") int id);

    @Modifying
    @Query("update UserMaster reg set reg.isActive =:status where reg.userId =:id")
     int  setUseractive(@Param("status") boolean status, @Param("id") int id);

    @Query("select password from UserMaster where userId=:id")
    String getPassword(@Param("id") int id);

    @Modifying
    @Query("update UserMaster reg set reg.password =:password where reg.userId =:id")
    void changePassword(@Param("password") String password, @Param("id") int id);

}
