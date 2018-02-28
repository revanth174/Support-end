package com.reddy.krjs.supportEnd.Model;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;





@Entity
@DynamicUpdate
@Table(catalog="dup",name="registered_Member")
public class MemberDup {


	@Column(name = "app_no", unique = true)
	private String appNo;

	@Id
	private String memberId;

	
	private boolean isDeleted;
	
	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	String remarks;

	@Column(name = "membershipType")
	private String type;

	@Column(name = "member_title")
	private String title;

	private String gender;

	@Column(name = "member_name", length = 40)
	private String name;

	@Column(name = "member_fname")
	private String fname;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "member_dateofbirth")
	private LocalDate dob;

	// @OneToOne(mappedBy = "member",cascade = CascadeType.ALL)
	@AttributeOverrides(value = {

			@AttributeOverride(column = @Column(name = "address"), name = "address"),
			@AttributeOverride(column = @Column(name = "city"), name = "city"),
			@AttributeOverride(column = @Column(name = "taluk"), name = "taluk"),
			@AttributeOverride(column = @Column(name = "district"), name = "district"),
			@AttributeOverride(column = @Column(name = "state"), name = "state"),
			@AttributeOverride(column = @Column(name = "pincode"), name = "pincode") })
	@Embedded
	private Address address;

	
	@OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
	private DetailsDup details;

	public DetailsDup getDetails() {
		return details;
	}

	public void setDetails(DetailsDup details) {
		this.details = details;
	}

	public PaymentDup getPayment() {
		return payment;
	}

	public void setPayment(PaymentDup payment) {
		this.payment = payment;
	}

	@OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
	private PaymentDup payment;
	
	
	

	public String getAppNo() {
		return appNo;
	}

	public void setAppNo(String appNo) {
		this.appNo = appNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFname() {
		return fname;
	}

	

	public void setFname(String fname) {
		this.fname = fname;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Member [appNo=" + appNo + ", memberId=" + memberId + ", type=" + type + ", title=" + title + ", gender="
				+ gender + ", name=" + name + ", fname=" + fname + ", dob=" + dob + ", address=" + address
				+ ", details=" + details + ", payment=" + payment + "]";
	}

	

	

	

}
