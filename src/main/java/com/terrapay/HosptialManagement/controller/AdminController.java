	package com.terrapay.HosptialManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.terrapay.HosptialManagement.request.DoctorInformation;
import com.terrapay.HosptialManagement.response.ApiResponse;
import com.terrapay.HosptialManagement.response.StatusResponse;
import com.terrapay.HosptialManagement.service.AdminService;

@RestController
public class AdminController {
@Autowired
AdminService adminService;

@GetMapping("/doctorInfo/{roleId}")
	public ApiResponse getDoctorInfo(@PathVariable int roleId) throws Exception
	{
		if(roleId!=1)
		{
			return StatusResponse.status_Failed("Only Admin can access this");
		}
		return StatusResponse.status_Ok(adminService.setDoctorInfo());
	}
}
