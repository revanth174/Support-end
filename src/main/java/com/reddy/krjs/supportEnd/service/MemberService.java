package com.reddy.krjs.supportEnd.service;

import java.util.HashMap;
import java.util.List;

import com.reddy.krjs.supportEnd.Model.Member;
import com.reddy.krjs.supportEnd.Model.MemberDup;
import com.reddy.krjs.supportEnd.Model.Users;
import com.reddy.krjs.supportEnd.Model.Ward;

public interface MemberService {
	int insertAndDelete(MemberDup m);
	int insert(Member m);
	void insert(Users user);
	void insert_registerMember(MemberDup m);
	void delete(Member m);
	void update(Member m);
	void update(MemberDup m);
	List<Member> selectAll();
	public void insert_user(Users user);
	Member getById(int id);
	MemberDup getById_registeredMember(int id);
	List<MemberDup> selectAll_registeredMembers(boolean a);
	List<Member> getByApplicationNumber(int appno);
	List<Member> getByMobileNumber(String phone);
	List<Member> getByDistrict(String dis);
	List<Member> getByState(String state);
	List<Member> getByTaluk(String taluk);
	List<Member> getByAlphabet(char a);
	List<Member> getByPincode(String pincode);
	Member checkMemberId(int memberid);
	void insert_code(String code,int id);
	public boolean checkCode(String code,int id);
    boolean changeUserPassword(String code,int id);
    public void addWard(Ward ward);
    public List<Ward> listOfWards();
    public boolean checkRefNo(String refno);
    public List<Integer> getAdmins();
    public HashMap<Integer,String> getIdAndName(Integer mid);	

}
