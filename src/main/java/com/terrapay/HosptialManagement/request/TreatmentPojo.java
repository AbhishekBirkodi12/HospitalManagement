package com.terrapay.HosptialManagement.request;

public class TreatmentPojo {
	
	private String doctorName;
	private String patientName;
	private String diesease;
	private String treatmentDesc;
	private int days;
	private Double fees;
	private String treatmentStartDate;
	private String treatmentEndDate;
	private Double treatmentBill;
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDiesease() {
		return diesease;
	}
	public void setDiesease(String diesease) {
		this.diesease = diesease;
	}
	public String getTreatmentDesc() {
		return treatmentDesc;
	}
	public void setTreatmentDesc(String treatmentDesc) {
		this.treatmentDesc = treatmentDesc;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public Double getFees() {
		return fees;
	}
	public void setFees(Double fees) {
		this.fees = fees;
	}
	public String getTreatmentStartDate() {
		return treatmentStartDate;
	}
	public void setTreatmentStartDate(String treatmentStartDate) {
		this.treatmentStartDate = treatmentStartDate;
	}
	public String getTreatmentEndDate() {
		return treatmentEndDate;
	}
	public void setTreatmentEndDate(String treatmentEndDate) {
		this.treatmentEndDate = treatmentEndDate;
	}
	public Double getTreatmentBill() {
		return treatmentBill;
	}
	public void setTreatmentBill(Double treatmentBill) {
		this.treatmentBill = treatmentBill;
	}
	
	
	
	
}
