package com.terrapay.HosptialManagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.terrapay.HosptialManagement.dao.DoctorDao;
import com.terrapay.HosptialManagement.dao.TreatmentDao;
import com.terrapay.HosptialManagement.request.DoctorInformation;

@Service
public class AdminService {
	@Autowired
	TreatmentDao treatmentDao;
	@Autowired
	DoctorDao doctorDao;

	public List<DoctorInformation> setDoctorInfo() {

		try {
			List<DoctorInformation> doctorInfo = new ArrayList<DoctorInformation>();
			List<Object> obj = doctorDao.getDoctorInfo();
			for (Object o : obj) {
				Object[] objects = (Object[]) o;
				DoctorInformation t = new DoctorInformation();
				t.setDoctorId(Integer.parseInt(objects[0].toString()));
				t.setFirstName(objects[1].toString());
				t.setLastName(objects[2].toString());
				t.setEmail(objects[3].toString());
				t.setPhone(objects[4].toString());
				t.setDepartmentName(objects[5].toString());
				t.setFees(objects[6].toString());
				t.setPatientTreated(treatmentDao.patientTreated(Integer.parseInt(objects[0].toString())));

				t.setTotalBillGenerated(Double.parseDouble(objects[6].toString()) * t.getPatientTreated() + "");
				doctorInfo.add(t);
			}

			return doctorInfo;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
