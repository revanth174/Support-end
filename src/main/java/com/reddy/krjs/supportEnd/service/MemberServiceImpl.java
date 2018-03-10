package com.reddy.krjs.supportEnd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reddy.krjs.supportEnd.Model.Member;
import com.reddy.krjs.supportEnd.Model.MemberDup;
import com.reddy.krjs.supportEnd.Model.Users;
import com.reddy.krjs.supportEnd.dao.MemberDao;

@Service("service")
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao memberdao;
	
	
	public void insert(Member m) {
		memberdao.insert(m);
		
	}

	public void delete(Member m) {
		memberdao.delete(m);
		
	}

	public void update(Member m) {
		memberdao.update(m);
		
	}

	public List<Member> selectAll() {
		return memberdao.selectAll();
	}

	public List<Member> getByApplicationNumber(String appno) {
		return memberdao.getByApplicationNumber(appno);
	}

	public List<Member> getByMobileNumber(Long phone) {
		return memberdao.getByMobileNumber(phone);
	}

	public List<Member> getByDistrict(String dis) {
		return memberdao.getByDistrict(dis);
	}

	public List<Member> getByState(String state) {
		return memberdao.getByState(state);
	}

	public List<Member> getByTaluk(String taluk) {
		return memberdao.getByTaluk(taluk);
	}

	public List<Member> getByAlphabet(char a) {
		return memberdao.getByAlphabet(a);
	}

	public List<Member> getByPincode(int pincode) {
		return memberdao.getByPincode(pincode);
	}

	public List<MemberDup> selectAll_registeredMembers(boolean a) {
		return memberdao.selectAll_registeredMembers(a);
	}

	public Member getById(String id) {
		return memberdao.getById(id);
		
	}

	public void insertAndDelete(MemberDup m) {
		memberdao.insertAndDelete(m);
		
	}

	public MemberDup getById_registeredMember(String id) {
		return memberdao.getById_registeredMember(id);
	}

	public void insert_registerMember(MemberDup m) {
		memberdao.insert_registeredMember(m);
	}

	public void update(MemberDup m) {
		memberdao.update(m);
	
		
	}

	public void insert(Users user) {
		memberdao.insert_user(user);
		
	}

}
