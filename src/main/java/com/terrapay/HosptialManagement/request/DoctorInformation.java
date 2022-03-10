package com.terrapay.HosptialManagement.request;

public class DoctorInformation {
	private int doctorId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String departmentName;
	private int patientTreated;
	private String fees;
	private String totalBillGenerated;
	
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public int getPatientTreated() {
		return patientTreated;
	}
	public void setPatientTreated(int patientTreated) {
		this.patientTreated = patientTreated;
	}
	public String getTotalBillGenerated() {
		return totalBillGenerated;
	}
	public void setTotalBillGenerated(String totalBillGenerated) {
		this.totalBillGenerated = totalBillGenerated;
	}
	
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getFees() {
		return fees;
	}
	public void setFees(String fees) {
		this.fees = fees;
	}
	
	
	
}
