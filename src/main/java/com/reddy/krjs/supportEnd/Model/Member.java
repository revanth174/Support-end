package com.reddy.krjs.supportEnd.Model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;





@Entity
@DynamicUpdate

public class Member {


	/*@Column(name = "app_no", unique = true)
	private String appNo;

	@Id
	private String memberId;

	
	

	@Column(name = "membershipType")
	private String type;

	@Column(name = "member_title")
	private String title;

	private String gender;

	@Column(name = "member_name", length = 40)
	private String name;
	
	private String fhname;

	
	public String getFhname() {
		return fhname;
	}

	public void setFhname(String fhname) {
		this.fhname = fhname;
	}

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

	public long getProposerPhoneNumber() {
		return proposerPhoneNumber;
	}

	public void setProposerPhoneNumber(long proposerPhoneNumber) {
		this.proposerPhoneNumber = proposerPhoneNumber;
	}

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "member_dateofbirth")
	private LocalDate dob;
	
	@Column(name = "ProposerName")
	String proposerName;

	String ProposerMemberId;

	long proposerPhoneNumber;

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
	private Details details;

	public Details getDetails() {
		return details;
	}

	public void setDetails(Details details) {
		this.details = details;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
	private Payment payment;
	
	
	

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
				+ gender + ", name=" + name + ", dob=" + dob + ", proposerName=" + proposerName
				+ ", ProposerMemberId=" + ProposerMemberId + ", proposerPhoneNumber=" + proposerPhoneNumber
				+ ", address=" + address + ", details=" + details + ", payment=" + payment + "]";
	}*/
	
	@Column(name = "app_no", unique = true)
	private String appNo;

	@Id
	private String memberId;

	
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

	@Column(name = "membershipType")
	private String type;

	@Column(name = "member_title")
	private String title;

	private String gender;

	@Column(name = "member_name", length = 40)
	private String name;
	
	private String fhname;

	
	public String getFhname() {
		return fhname;
	}

	public void setFhname(String fhname) {
		this.fhname = fhname;
	}

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

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "member_dateofbirth")
	private Date dob;
	
	@Column(name = "ProposerName")
	String proposerName;

	String ProposerMemberId;

	String proposerPhoneNumber;

	// @OneToOne(mappedBy = "member",cascade = CascadeType.ALL)
	@AttributeOverrides(value = {

			@AttributeOverride(column = @Column(name = "address"), name = "address"),
			@AttributeOverride(column = @Column(name = "village"), name = "village"),
			@AttributeOverride(column = @Column(name = "taluk"), name = "taluk"),
			@AttributeOverride(column = @Column(name = "district"), name = "district"),
			@AttributeOverride(column = @Column(name = "state"), name = "state"),
			@AttributeOverride(column = @Column(name = "pincode"), name = "pincode") })
	@Embedded
	private Address address;

	
	@OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
	private Details details;

	public Details getDetails() {
		return details;
	}

	public void setDetails(Details details) {
		this.details = details;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
	private Payment payment;
	
	
	

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
		return "Member [appNo=" + appNo + ", memberId=" + memberId + ", type=" + type + ", title=" + title + ", gender="
				+ gender + ", name=" + name + ", dob=" + dob + ", proposerName=" + proposerName
				+ ", ProposerMemberId=" + ProposerMemberId + ", proposerPhoneNumber=" + proposerPhoneNumber
				+ ", address=" + address + ", details=" + details + ", payment=" + payment + "]";
	}

	

	

	

	

}
