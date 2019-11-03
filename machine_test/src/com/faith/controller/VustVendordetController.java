package com.faith.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.faith.dao.IVustVendordetDao;
import com.faith.model.VustVendorDet;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class VustVendordetController {
	@Autowired
	private IVustVendordetDao dao;
	@RequestMapping(value = "/vvendordetails", method = RequestMethod.GET)
	public List getVendordetDetails() {
		List list;
		list = dao.getAllVendordetDetails();
		return list;
	}
	@RequestMapping(value = "/insertvvendor", method = RequestMethod.POST)
	public void insertDetails(@RequestBody VustVendorDet vu) {
		System.out.println("Inside  controller");
		System.out.println("object vu:"+vu);
		dao.insertVendordetDetails(vu);
	}
	@RequestMapping(value = "/disablevendor/{vdId}", method = RequestMethod.PUT)
	void disableMaster(@PathVariable("vdId") int vdId) {
		dao.disableVendordet(vdId);
	}
	
	@RequestMapping(value = "/getvvendorid/{vdId}", method = RequestMethod.GET)
	public VustVendorDet getvendorDetails(@PathVariable("vdId") int vdId) {
		VustVendorDet vd = (VustVendorDet) dao.getVendordetById(vdId);
		return vd;
	}
	@RequestMapping(value = "/updatvvendor/{vdId}", method = RequestMethod.PUT)
	public void updateDetails(@RequestBody VustVendorDet vd) {
		dao.updateVendordetDetails(vd);
	}
	
	@RequestMapping(value = "/duplication/{cpPhone}/{cpEmail}", method = RequestMethod.GET)
	public VustVendorDet duplication(@PathVariable(value = "cpPhone") String cpPhone,
			@PathVariable(value = "cpEmail") String cpEmail) {
		VustVendorDet vvdet = (VustVendorDet)dao.duplication(cpPhone,cpEmail);
		return vvdet;

	}
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/searchdet/{searchString}", method = RequestMethod.GET)
	public List searchVvendordet(@PathVariable("searchString") String searchString) {
		List list;
		if(searchString.equals("null")) {
			list = dao.getAllVendordetDetails();	
		}
		else{
			list =dao.searchVvendor(searchString);
		}
		return list;
	}
	

}
