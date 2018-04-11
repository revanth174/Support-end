package com.reddy.krjs.supportEnd.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ward {
	
	@Id
	@GeneratedValue
	int id;
	
	private String wardName;
	
	private String wardNumber;

	public Ward() {
		super();
	}

	public Ward(String wardName, String wardNumber) {
		super();
		this.wardName = wardName;
		this.wardNumber = wardNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWardName() {
		return wardName;
	}

	public void setWardName(String wardName) {
		this.wardName = wardName;
	}

	public String getWardNumber() {
		return wardNumber;
	}

	public void setWardNumber(String wardNumber) {
		this.wardNumber = wardNumber;
	}

}
