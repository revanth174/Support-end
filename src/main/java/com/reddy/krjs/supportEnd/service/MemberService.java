package com.reddy.krjs.supportEnd.service;

import java.util.List;

import com.reddy.krjs.supportEnd.Model.Member;
import com.reddy.krjs.supportEnd.Model.MemberDup;
import com.reddy.krjs.supportEnd.Model.Users;

public interface MemberService {
	void insertAndDelete(MemberDup m);
	void insert(Member m);
	void insert(Users user);
	void insert_registerMember(MemberDup m);
	void delete(Member m);
	void update(Member m);
	void update(MemberDup m);
	List<Member> selectAll();
	Member getById(String id);
	MemberDup getById_registeredMember(String id);
	List<MemberDup> selectAll_registeredMembers(boolean a);
	List<Member> getByApplicationNumber(String appno);
	List<Member> getByMobileNumber(Long phone);
	List<Member> getByDistrict(String dis);
	List<Member> getByState(String state);
	List<Member> getByTaluk(String taluk);
	List<Member> getByAlphabet(char a);
	List<Member> getByPincode(int pincode);

}
