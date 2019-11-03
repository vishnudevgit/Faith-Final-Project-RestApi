package com.faith.model;

public class VustVendorDet {
	int vdId;
	String vdName;
	String vdAddr;
	String vdLocation;
	String vdService;
	int vdPin;
	int cpId;
	int cpVdid;
	String cpName;
	String cpDepartment;
	String cpEmail;
	String cpPhone;
	String isActive;
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public int getVdId() {
		return vdId;
	}
	public void setVdId(int vdId) {
		this.vdId = vdId;
	}
	public String getVdName() {
		return vdName;
	}
	public void setCpName(String cpName) {
		this.cpName = cpName;
	}
	public String getCpName() {
		return cpName;
	}
	public void setVdName(String vdName) {
		this.vdName = vdName;
	}
	public String getVdAddr() {
		return vdAddr;
	}
	public void setVdAddr(String vdAddr) {
		this.vdAddr = vdAddr;
	}
	public String getVdLocation() {
		return vdLocation;
	}
	public void setVdLocation(String vdLocation) {
		this.vdLocation = vdLocation;
	}
	public String getVdService() {
		return vdService;
	}
	public void setVdService(String vdService) {
		this.vdService = vdService;
	}
	public int getVdPin() {
		return vdPin;
	}
	public void setVdPin(int vdPin) {
		this.vdPin = vdPin;
	}
	public int getCpId() {
		return cpId;
	}
	public void setCpId(int cpId) {
		this.cpId = cpId;
	}
	public int getCpVdid() {
		return cpVdid;
	}
	public void setCpVdid(int cpVdid) {
		this.cpVdid = cpVdid;
	}
	public String getCpDepartment() {
		return cpDepartment;
	}
	public void setCpDepartment(String cpDepartment) {
		this.cpDepartment = cpDepartment;
	}
	public String getCpEmail() {
		return cpEmail;
	}
	public void setCpEmail(String cpEmail) {
		this.cpEmail = cpEmail;
	}
	public String getCpPhone() {
		return cpPhone;
	}
	public void setCpPhone(String l) {
		this.cpPhone = l;
	}

	public VustVendorDet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VustVendorDet(int vdId, String vdName, String vdAddr, String vdLocation, String vdService, int vdPin,
			int cpId, int cpVdid, String cpName, String cpDepartment, String cpEmail, String cpPhone, String isActive) {
		super();
		this.vdId = vdId;
		this.vdName = vdName;
		this.vdAddr = vdAddr;
		this.vdLocation = vdLocation;
		this.vdService = vdService;
		this.vdPin = vdPin;
		this.cpId = cpId;
		this.cpVdid = cpVdid;
		this.cpName = cpName;
		this.cpDepartment = cpDepartment;
		this.cpEmail = cpEmail;
		this.cpPhone = cpPhone;
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "VustVendorDet [vdId=" + vdId + ", vdName=" + vdName + ", vdAddr=" + vdAddr + ", vdLocation="
				+ vdLocation + ", vdService=" + vdService + ", vdPin=" + vdPin + ", cpId=" + cpId + ", cpVdid=" + cpVdid
				+ ", cpName=" + cpName + ", cpDepartment=" + cpDepartment + ", cpEmail=" + cpEmail + ", cpPhone="
				+ cpPhone + ", isActive=" + isActive + "]";
	}
	
	
	

}
