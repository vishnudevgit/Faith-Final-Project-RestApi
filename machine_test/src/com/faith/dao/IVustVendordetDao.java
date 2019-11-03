package com.faith.dao;

import java.util.List;

import com.faith.model.VustVendorDet;

public interface IVustVendordetDao {
	public abstract List<VustVendorDet> getAllVendordetDetails();

	public abstract VustVendorDet getVendordetById(int vdId);

	public abstract int disableVendordet(int vdId);

	public abstract int insertVendordetDetails(VustVendorDet uv);

	public abstract int updateVendordetDetails(VustVendorDet uv);
	
	public abstract VustVendorDet duplication(String cpPhone, String cpEmail);
	
	public abstract List<VustVendorDet> searchVvendor(String searchString);


	
}
