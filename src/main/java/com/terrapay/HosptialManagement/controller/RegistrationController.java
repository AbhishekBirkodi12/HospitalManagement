package com.terrapay.HosptialManagement.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import com.terrapay.HosptialManagement.entities.UserMaster;
import com.terrapay.HosptialManagement.request.ChangePasswordRequest;
import com.terrapay.HosptialManagement.request.RegistrationRequest;
import com.terrapay.HosptialManagement.response.ApiResponse;
import com.terrapay.HosptialManagement.response.StatusResponse;
import com.terrapay.HosptialManagement.service.RegistrationService;

@RestController
public class RegistrationController {
    ApiResponse response;
    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/user")
    public ApiResponse registerUser(@Valid @RequestBody RegistrationRequest userRegistration, BindingResult result) {

    	List<String> messages = new ArrayList<String>();
		if (result.hasErrors()) {
			for (ObjectError er : result.getAllErrors()) {
				messages.add(er.getDefaultMessage());
			}
			return StatusResponse.status_Failed(messages);
		}
       
        boolean isSuccess = false;
        try {
            isSuccess = registrationService.registerNewUser(userRegistration);

        } catch (Exception e) {
            response = StatusResponse.status_Failed("user already exists please login");
            return response;
        }
        if (isSuccess) {
            response = StatusResponse.status_Ok("User Registration successful");
        } else {
            response = StatusResponse.status_Failed("Registration unsuccessful");
        }

        return response;
    }

    @GetMapping("/users")
    public List<UserMaster> getUsers() {
        return registrationService.getUsers();
    }

    @GetMapping("/user/{id}")
    public ApiResponse getUserByID(@PathVariable int id) {
        UserMaster user=registrationService.getUserByID(id);
        if (user==null) {
            return StatusResponse.status_Failed("User doesn't exists");
        }
        return StatusResponse.userById(user);

    }

    @PostMapping("/user/{id}")
    public ApiResponse updateUser(@Valid @PathVariable int id, @RequestBody UserMaster master,BindingResult result) {
        List<String> messages = new ArrayList<String>();
        if (result.hasErrors()) {
            for (ObjectError er : result.getAllErrors()) {
                messages.add(er.getDefaultMessage());
            }
            return StatusResponse.status_Failed(messages);
        }
        UserMaster user=registrationService.updateUser(id,master);
        if (user==null) {
            return StatusResponse.status_Failed("User cannot be updated as there is already a user with this data");
        }
        return StatusResponse.userById(user);
    }

    @DeleteMapping("/user/{id}")
    public ApiResponse deleteUser(@PathVariable int id) {



              boolean isSuccess = registrationService.deleteUser(id);
        if (isSuccess) {
            response = StatusResponse.status_Ok("User deleted successfully");
        } else {
            response = StatusResponse.status_Failed("Something went wrong!! ");
        }
        return response;
    }

    @PostMapping("/changePassword/{id}")
    public ApiResponse changePassword(@Valid @RequestBody ChangePasswordRequest changePassword, @PathVariable int id,BindingResult result) {

        List<String> messages = new ArrayList<String>();
        if (result.hasErrors()) {
            for (ObjectError er : result.getAllErrors()) {
                messages.add(er.getDefaultMessage());
            }
            return StatusResponse.status_Failed(messages);
        }

        UserMaster user=registrationService.getUserByID(id);
        if (user==null) {
            return StatusResponse.status_Failed("User doesn't exists");
        }
           if (changePassword.getOldPassword().equals(changePassword.getNewPassword())) {
               return StatusResponse.status_Failed("Old password and new password are the same!!");
           }


        if (changePassword.getNewPassword().equals(changePassword.getConfirmPassword())) {
           boolean res= registrationService.changePassword(changePassword, id);
           if(res==false)
           {
               return StatusResponse.status_Failed("Old password is incorrect!");
           }
           return StatusResponse.status_Ok("Password changed successfully");
        }
        return StatusResponse.status_Failed("New password and the confirm password not matching ");


    }
}
