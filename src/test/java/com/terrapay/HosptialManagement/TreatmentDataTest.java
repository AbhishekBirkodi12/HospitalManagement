package com.terrapay.HosptialManagement;

import com.terrapay.HosptialManagement.dao.TreatmentDao;
import com.terrapay.HosptialManagement.entities.Treatment;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TreatmentDataTest {

    @Autowired
    private TreatmentDao treatmentDao;

    @Test
    @Order(1)
    public void createTreatment(){
        Treatment treatment=new Treatment();
        treatment.setTreatmentId(100);
        treatment.setTreatmentDescription("Description 1");
        treatment.setDisease("Eye problem");
        treatment.setUserId(2);
        treatment.setPatientId(1);
        treatment.setDepartmentId(1);
        treatment.setTreatmentStartDate(new Date(2022,02,15));
        treatment.setTreatmentEndDate(new Date(2022,02,18));
        treatmentDao.save(treatment);
        assertNotNull(treatmentDao.findById(1).get());


    }




}
