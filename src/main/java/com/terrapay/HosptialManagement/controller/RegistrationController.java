package com.terrapay.HosptialManagement.controller;

import com.terrapay.HosptialManagement.entities.Registration;
import com.terrapay.HosptialManagement.request.RegistrationRequest;
import com.terrapay.HosptialManagement.response.ApiResponse;
import com.terrapay.HosptialManagement.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegistrationController {
   @Autowired
   private RegistrationService registrationService;

   @PostMapping("/registerUser")
    public ApiResponse registerUser(@RequestBody RegistrationRequest userRegistration) {

       ApiResponse response =new ApiResponse();
       boolean isSuccess = registrationService.registerNewUser(userRegistration);
       if (isSuccess==true){
           response.setSuccess(true);
           response.setStatus("success");
           response.getResult().put("success", "registration successful");
       }else {
           response.setSuccess(false);
           response.setStatus("failed");
           response.getResult().put("failed", "something went wrong");
       }

       return response;
   }

   @GetMapping("/getUsers")
    public List<Registration> getUsers() {
       return registrationService.getUsers();
   }

   @GetMapping("/getUser/{id}")
    public Registration getUserByID(@PathVariable int id) {
       return registrationService.getUserByID(id);
   }

   @PutMapping("/updateUser/{id}")
    public Registration updateUser(@PathVariable int id, @RequestBody Registration master){
       return registrationService.updateUser(id, master);
   }

   @DeleteMapping("/deleteUser/{id}")
    public ApiResponse deleteUser(@PathVariable int id){
       ApiResponse response =new ApiResponse();
       boolean isSuccess= registrationService.deleteUser(id);
       if (isSuccess){
           response.setSuccess(true);
           response.setStatus("success");
           response.getResult().put("success", "Deleted successfully");
       }else {
           response.setSuccess(false);
           response.setStatus("failed");
           response.getResult().put("failed", "something went wrong");
       }
       return response;
   }


}
