package com.reddy.krjs.supportEnd.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="EMPLOYEE")
public class Emp {
	
	@Id
//	@GeneratedValue(generator = "SequenceIdGenerator")
//	@SequenceGenerator(name = "SequenceIdGenerator", 
//					    sequenceName = "SEQ_ID_GEN", initialValue = 100, 
//					    allocationSize = 1)
	@Column(name="employee_id")
	private int employeeId;

	@Column(name="firstname")
	private String firstname;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	@Column(name="lastname")
	private String lastname;

	@Column(name="birth_date")
	private Date birthDate;

	@Column(name="cell_phone")
	private String cellphone;

	//Getter and Setter methods

}
