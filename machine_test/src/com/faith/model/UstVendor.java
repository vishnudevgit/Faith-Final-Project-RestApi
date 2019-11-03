package com.faith.model;

public class UstVendor {
	int vdId;
	int vdName;
	String VdAddr;
	String vdLocation;
	String vdService;
	int vdPin;
	String isActive;
	public int getVdId() {
		return vdId;
	}
	public void setVdId(int vdId) {
		this.vdId = vdId;
	}
	public int getVdName() {
		return vdName;
	}
	public void setVdName(int vdName) {
		this.vdName = vdName;
	}
	public String getVdAddr() {
		return VdAddr;
	}
	public void setVdAddr(String vdAddr) {
		VdAddr = vdAddr;
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
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "UstVendor [vdId=" + vdId + ", vdName=" + vdName + ", VdAddr=" + VdAddr + ", vdLocation=" + vdLocation
				+ ", vdService=" + vdService + ", vdPin=" + vdPin + ", isActive=" + isActive + "]";
	}
	public UstVendor(int vdId, int vdName, String vdAddr, String vdLocation, String vdService, int vdPin,
			String isActive) {
		super();
		this.vdId = vdId;
		this.vdName = vdName;
		VdAddr = vdAddr;
		this.vdLocation = vdLocation;
		this.vdService = vdService;
		this.vdPin = vdPin;
		this.isActive = isActive;
	}
	public UstVendor() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
