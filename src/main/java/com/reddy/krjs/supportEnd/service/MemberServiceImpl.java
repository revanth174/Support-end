package com.reddy.krjs.supportEnd.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reddy.krjs.supportEnd.Model.Member;
import com.reddy.krjs.supportEnd.Model.MemberDup;
import com.reddy.krjs.supportEnd.Model.Users;
import com.reddy.krjs.supportEnd.Model.Ward;
import com.reddy.krjs.supportEnd.dao.MemberDao;

@Service("service")
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao memberdao;
	
	
	public int insert(Member m) {
		return memberdao.insert(m);
		
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

	public List<Member> getByApplicationNumber(int appno) {
		return memberdao.getByApplicationNumber(appno);
	}

	public List<Member> getByMobileNumber(String phone) {
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

	public List<Member> getByPincode(String pincode) {
		return memberdao.getByPincode(pincode);
	}

	public List<MemberDup> selectAll_registeredMembers(boolean a) {
		return memberdao.selectAll_registeredMembers(a);
	}

	public Member getById(int id) {
		return memberdao.getById(id);
		
	}

	public int insertAndDelete(MemberDup m) {
		return memberdao.insertAndDelete(m);
		
	}

	public MemberDup getById_registeredMember(int id) {
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

	@Override
	public Member checkMemberId(int memberid) {
		return memberdao.getById(memberid);
	
	}

	@Override
	public void insert_code(String code, int id) {
		memberdao.insert_code(code, id);
		
	}

	@Override
	public boolean checkCode(String code, int id) {
		try {
			memberdao.checkCode(code, id);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean changeUserPassword(String code, int id) {
		try {
			memberdao.changeUserPassword(code, id);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public void addWard(Ward ward) {
		memberdao.addWard(ward);
		
		
	}

	@Override
	public List<Ward> listOfWards() {
		return memberdao.listOfWards();
	}


	public boolean checkRefNo(String refno) {
		// TODO Auto-generated method stub
		return memberdao.checkRefNo(refno);
	}

	
	public List<Integer> getAdmins() {
		return memberdao.getAdmins();
	}

	
	public HashMap<Integer, String> getIdAndName(Integer mid) {
		return memberdao.getIdAndName(mid);
		
	}

	@Override
	public void insert_user(Users user) {
		memberdao.insert_user(user);
	}
	
	

}
