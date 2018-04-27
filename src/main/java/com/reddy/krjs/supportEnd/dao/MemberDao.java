package com.reddy.krjs.supportEnd.dao;

import java.util.HashMap;
import java.util.List;

import com.reddy.krjs.supportEnd.Model.Emp;
import com.reddy.krjs.supportEnd.Model.Gen_Seq;
import com.reddy.krjs.supportEnd.Model.Member;
import com.reddy.krjs.supportEnd.Model.MemberDup;
import com.reddy.krjs.supportEnd.Model.Users;
import com.reddy.krjs.supportEnd.Model.Ward;


public interface MemberDao {
	
	int insertAndDelete(MemberDup member);
	int  insert(Member m);
	boolean insert_registeredMember(MemberDup m);
	boolean delete(Member m);
	boolean update(Member m);
	boolean update(MemberDup m);
	List<Member> selectAll();
	Member getById(int id);
	MemberDup getById_registeredMember(int id);
	List<MemberDup> selectAll_registeredMembers(boolean a);
	List<Member> getByApplicationNumber(int appno);
	List<Member> getByMobileNumber(String phone);
	List<Member> getByDistrict(String dis);
	public List<Member> getBySDT(String state,String district,String taluk);
	List<Member> getByState(String state);
	List<Member> getByTaluk(String taluk);
	List<Member> getByAlphabet(char a);
	List<Member> getByPincode(String pincode);
	void insert_user(Users user);
	void insert_code(String code,int id);
	public boolean checkCode(String code,int id);
    boolean changeUserPassword(String code,int id);
    public void addWard(Ward ward);
    public List<Ward> listOfWards();
    //public Gen_Seq getNextVal();
    public int insertEmp(Emp e);
    public boolean checkRefNo(String refno);
    public List<Integer> getAdmins();
    public HashMap<Integer,String> getIdAndName(Integer mid);	

}
