package com.terrapay.HosptialManagement.request;

import com.terrapay.HosptialManagement.entities.Department;
import com.terrapay.HosptialManagement.entities.Doctor;

import java.text.DecimalFormat;

public class RegistrationRequest {


    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String password;
    private Department department;
    private double fees;
    private String phoneNumber;
    private String alternatePhoneNumber;
    private String gender;
    private int roleId;
    private Doctor doctor;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Doctor getDoctorInfo() {
        return doctor;
    }

    public void setDoctorInfo(Doctor doctor) {
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
}
