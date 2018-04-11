package com.reddy.krjs.supportEnd.Model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	@Override
	public String toString() {
		return address + "  " + village + " " + taluk + " tq " + district + " dist \n" + state+ "-" + pincode ;
	}

	@Column(name = "address")
	String address;

	
	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	

	
	String taluk;

	@Column(name = "district")
	String district;

	
	String village;

	@Column(name = "state")
	String state;

	@Column(name = "pincode")
	String pincode;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTaluk() {
		return taluk;
	}

	public void setTaluk(String taluk) {
		this.taluk = taluk;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
}
