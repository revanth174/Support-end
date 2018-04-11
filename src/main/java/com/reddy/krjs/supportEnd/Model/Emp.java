package com.reddy.krjs.supportEnd.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="EMPLOYEE")
public class Emp {
	
	@Id
	@GenericGenerator(name = "sequence_emp_id", strategy = "com.reddy.krjs.supportEnd.Model.EmployeeIdGenerator")
	@GeneratedValue(generator = "sequence_emp_id")  
	@Column(name="employee_id")
	private String employeeId;

	@Column(name="firstname")
	private String firstname;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
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
