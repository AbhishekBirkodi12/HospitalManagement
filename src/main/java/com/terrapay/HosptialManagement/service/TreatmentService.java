
package com.terrapay.HosptialManagement.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.terrapay.HosptialManagement.dao.TreatmentDao;
import com.terrapay.HosptialManagement.entities.Treatment;
import com.terrapay.HosptialManagement.request.TreatmentPojo;

@Service
public class TreatmentService {

	@Autowired
	private TreatmentDao treatmentDao;

	public boolean addTreatment(Treatment treatment) {
		try {
			treatment.setCreatedDate(new Date());
			treatmentDao.save(treatment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<TreatmentPojo> getTreatmentInfo()
	    {
	    	List<TreatmentPojo> treatment=new ArrayList<TreatmentPojo>();
	    	List<Object> obj=treatmentDao.getTreatmentInfo();
	    	for(Object o:obj)
	    	{
	    		Object[] objects = (Object[]) o;
	    		TreatmentPojo t=new TreatmentPojo();
	    		t.setDoctorName(objects[0].toString());
	    		t.setPatientName(objects[1].toString());
	    		t.setDiesease(objects[2].toString());
	    		t.setTreatmentDesc(objects[3].toString());
	    		t.setDays(Integer.parseInt(objects[4].toString()));
	    		t.setFees(Double.parseDouble(objects[5].toString()));
	    		t.setTreatmentStartDate(objects[6].toString());
	    		t.setTreatmentEndDate(objects[7].toString());
	    		Double fees=Double.parseDouble(objects[5].toString());
	    		int days=Integer.parseInt(objects[4].toString());
	    		t.setTreatmentBill(fees*days);
	    		treatment.add(t);
	    	}
	    	return treatment;
	    }
}
