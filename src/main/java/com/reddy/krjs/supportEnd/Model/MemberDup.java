package com.reddy.krjs.supportEnd.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;





@Entity
@DynamicUpdate
@Table(catalog="dup",name="registered_Member")
public class MemberDup {

	@Id
	@Column(name="employee_id")
	int memberId;

	@Column(name = "app_no", unique = true)
	private int appNo;

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
	
	private String fhname;
	
	private String pan;
	private String aadhar;
	private String voter;
	
	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getVoter() {
		return voter;
	}

	public void setVoter(String voter) {
		this.voter = voter;
	}

	public String getFhname() {
		return fhname;
	}

	public void setFhname(String fhname) {
		this.fhname = fhname;
	}

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "member_dateofbirth")
	private Date dob;
	
	
	@Column(name = "ProposerName")
	String proposerName;

	String ProposerMemberId;

	String proposerPhoneNumber;

	public String getProposerName() {
		return proposerName;
	}

	public void setProposerName(String proposerName) {
		this.proposerName = proposerName;
	}

	public String getProposerMemberId() {
		return ProposerMemberId;
	}

	public void setProposerMemberId(String proposerMemberId) {
		ProposerMemberId = proposerMemberId;
	}

	public String getProposerPhoneNumber() {
		return proposerPhoneNumber;
	}

	public void setProposerPhoneNumber(String proposerPhoneNumber) {
		this.proposerPhoneNumber = proposerPhoneNumber;
	}

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
	
	
	

	public int getAppNo() {
		return appNo;
	}

	public void setAppNo(int appNo) {
		this.appNo = appNo;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
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

	

	

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
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
		return "MemberDup [appNo=" + appNo + ", memberId=" + memberId + ", isDeleted=" + isDeleted + ", remarks="
				+ remarks + ", type=" + type + ", title=" + title + ", gender=" + gender + ", name=" + name + ", dob=" + dob + ", proposerName=" + proposerName + ", ProposerMemberId=" + ProposerMemberId
				+ ", proposerPhoneNumber=" + proposerPhoneNumber + ", address=" + address + ", details=" + details
				+ ", payment=" + payment + "]";
	}

	

	

	

	

}
