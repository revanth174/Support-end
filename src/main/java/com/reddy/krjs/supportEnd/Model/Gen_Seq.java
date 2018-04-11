package com.reddy.krjs.supportEnd.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Gen_Seq {
	
	@Id
	int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	String nextVal ;

	public Gen_Seq() {
		super();
		this.nextVal = "M01";
	}

	public String getNextVal() {
		return nextVal;
	}

	public void setNextVal(String nextVal) {
		this.nextVal = nextVal;
	}
	
	

}
