package com.terrapay.HosptialManagement.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.terrapay.HosptialManagement.entities.Department;
import com.terrapay.HosptialManagement.entities.Doctor;
import com.terrapay.HosptialManagement.entities.Patient;

import javax.persistence.Column;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.text.DecimalFormat;

public class RegistrationRequest {

    @NotEmpty(message = "first name must be passed!!Please check your input")
    private String firstName;

    private String middleName;
   
    
    @NotEmpty(message = "last name must be passed!!Please check your input")
    private String lastName;
     
    @NotEmpty(message = "Email address must be passed!!Please check your input")
    private String emailAddress;  
    @NotEmpty(message = "password must be passed!!Please check your input")
    private String password;
    

  
    private double fees;
    
    @NotEmpty(message = "phone number must be passed!!Please check your input")
    private String phoneNumber;

    private String alternatePhoneNumber;
    private String gender;
   
    @JsonProperty
    private boolean isActive;
    @Digits(fraction = 0, integer = 10)
    private int roleId;
 
    private Doctor doctor;
    
    private Patient patient;
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getAlternatePhoneNumber() {
        return alternatePhoneNumber;
    }

    public void setAlternatePhoneNumber(String alternatePhoneNumber) {
        this.alternatePhoneNumber = alternatePhoneNumber;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

   

    public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public double getFees() {


        return fees;
    }

    public void setFees(double fees) {
        DecimalFormat df = new DecimalFormat("#.##");
        double fees1 = Double.parseDouble(df.format(fees));
        this.fees = fees1;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


}
