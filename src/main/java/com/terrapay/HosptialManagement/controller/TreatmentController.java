package com.terrapay.HosptialManagement.controller;

import com.terrapay.HosptialManagement.entities.Treatment;
import com.terrapay.HosptialManagement.request.TreatmentPojo;
import com.terrapay.HosptialManagement.response.ApiResponse;
import com.terrapay.HosptialManagement.response.StatusResponse;
import com.terrapay.HosptialManagement.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TreatmentController {
    ApiResponse response;
    @Autowired
    private TreatmentService treatmentService;

    @PostMapping("/treatment")
    public ApiResponse addTreatment(@RequestBody Treatment treatment){


           boolean isSuccess = treatmentService.addTreatment(treatment);

        if (isSuccess) {
            response = StatusResponse.status_Ok("Treatment added successfully");
        } else {
            response = StatusResponse.status_Failed("Treatment could not be added");
        }
        return response;

    }


    @GetMapping("/patientSummary/{roleId}")
    public ApiResponse getTreatment(@PathVariable int roleId) {
    	if(roleId ==3 || roleId==4|| roleId==5)
		{
			return StatusResponse.status_Failed("Only Admin and Doctor can access this");
		}
    	return StatusResponse.status_Ok(treatmentService.getTreatmentInfo());
	}
}
