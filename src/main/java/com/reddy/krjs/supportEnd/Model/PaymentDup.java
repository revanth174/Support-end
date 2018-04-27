package com.reddy.krjs.supportEnd.Model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;





@Entity
@Table(catalog="dup",name="register_member_payment")
public class PaymentDup {

	

	@Override
	public String toString() {
		return "PaymentDup [memberid=" + memberid + ", feePaid=" + feePaid + ", mop=" + mop + ", refNo=" + refNo
				+ ", ApplicationDate=" + ApplicationDate + "]";
	}

	@Id
	@GeneratedValue(generator = "gen")
	@GenericGenerator(name = "gen", strategy = "foreign", parameters = {
			@Parameter(name = "property", value = "member") })
	@Column(name = "member_id")
	int memberid;

	@OneToOne
	@PrimaryKeyJoinColumn
	MemberDup member = new MemberDup();

	public MemberDup getMember() {
		return member;
	}

	public void setMember(MemberDup member) {
		this.member = member;
	}

	@Column(name = "Paid_amount")
	BigDecimal feePaid;

	@Column(name = "ModeOfPayment")
	String mop;

	public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	public BigDecimal getFeePaid() {
		return feePaid;
	}

	public void setFeePaid(BigDecimal feePaid) {
		this.feePaid = feePaid;
	}

	public String getMop() {
		return mop;
	}

	public void setMop(String mop) {
		this.mop = mop;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}


	public Date getApplicationDate() {
		return ApplicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		ApplicationDate = applicationDate;
	}

	@Column(name = "refNo")
	String refNo;

	
	@Column(name = "ApplicationDate")
	@Temporal(TemporalType.TIMESTAMP)
	Date ApplicationDate = new Date();

}
