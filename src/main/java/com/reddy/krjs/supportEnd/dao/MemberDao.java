package com.reddy.krjs.supportEnd.dao;

import java.util.List;

import com.reddy.krjs.supportEnd.Model.Emp;
import com.reddy.krjs.supportEnd.Model.Gen_Seq;
import com.reddy.krjs.supportEnd.Model.Member;
import com.reddy.krjs.supportEnd.Model.MemberDup;
import com.reddy.krjs.supportEnd.Model.Users;
import com.reddy.krjs.supportEnd.Model.Ward;


public interface MemberDao {
	
	void insertAndDelete(MemberDup member);
	boolean insert(Member m);
	boolean insert_registeredMember(MemberDup m);
	boolean delete(Member m);
	boolean update(Member m);
	boolean update(MemberDup m);
	List<Member> selectAll();
	Member getById(String id);
	MemberDup getById_registeredMember(String id);
	List<MemberDup> selectAll_registeredMembers(boolean a);
	List<Member> getByApplicationNumber(String appno);
	List<Member> getByMobileNumber(String phone);
	List<Member> getByDistrict(String dis);
	List<Member> getByState(String state);
	List<Member> getByTaluk(String taluk);
	List<Member> getByAlphabet(char a);
	List<Member> getByPincode(String pincode);
	void insert_user(Users user);
	void insert_code(String code,String id);
	public boolean checkCode(String code,String id);
    boolean changeUserPassword(String code,String id);
    public void addWard(Ward ward);
    public List<Ward> listOfWards();
    //public Gen_Seq getNextVal();
    public void insertEmp(Emp e);
	

}
