package com.reddy.krjs.supportEnd.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.reddy.krjs.supportEnd.Model.Address;
import com.reddy.krjs.supportEnd.Model.Details;
import com.reddy.krjs.supportEnd.Model.Member;
import com.reddy.krjs.supportEnd.Model.MemberDup;
import com.reddy.krjs.supportEnd.Model.Payment;
import com.reddy.krjs.supportEnd.Model.Users;
import com.reddy.krjs.supportEnd.dao.MemberDao;

@Transactional
@Repository("memberdao")
public class MemberDaoImpl implements MemberDao {

	@Autowired
	SessionFactory sessionFactory;
	

	
	
	@Transactional
	public void insertAndDelete(MemberDup member) {
		Session s = sessionFactory.getCurrentSession();
		
		Member m = getMember(member);
		
		s.persist(m);
		s.delete(member);
		
	}

	private Member getMember(MemberDup member) {
		Member m = new Member();
		m.setMemberId(member.getMemberId());
		m.setAppNo(member.getAppNo());
		m.setDob(member.getDob());
		m.setFname(member.getFname());
		m.setGender(member.getGender());
		m.setName(member.getName());
		m.setTitle(member.getTitle());
		m.setType(member.getType());
		
		
		Details details = new Details();
		details.setGmail(member.getDetails().getGmail());
		details.setMaritalStatus(member.getDetails().getMaritalStatus());
		details.setNoc(member.getDetails().getNoc());
		details.setOccupation(member.getDetails().getOccupation());
		details.setPhone(member.getDetails().getPhone());
		details.setQualification(member.getDetails().getQualification());
		details.setVemanaVani(member.getDetails().getVemanaVani());
		details.setWard(member.getDetails().getWard());
		details.setWardNo(member.getDetails().getWardNo());
		details.setMember(m);
		
		Payment payment = new Payment();
		payment.setApplicationDate(member.getPayment().getApplicationDate());
		payment.setFeePaid(member.getPayment().getFeePaid());
		payment.setMop(member.getPayment().getMop());
		payment.setProposerMemberId(member.getPayment().getProposerMemberId());
		payment.setProposerName(member.getPayment().getProposerName());
		payment.setProposerPhoneNumber(member.getPayment().getProposerPhoneNumber());
		payment.setRefNo(member.getPayment().getRefNo());
		payment.setMember(m);
		
		
		Address address = new Address();
		address.setAddress(member.getAddress().getAddress());
		address.setCity(member.getAddress().getCity());
		address.setDistrict(member.getAddress().getDistrict());
		address.setPincode(member.getAddress().getPincode());
		address.setState(member.getAddress().getState());
		address.setTaluk(member.getAddress().getTaluk());
		
		m.setDetails(details);
		m.setPayment(payment);
		m.setAddress(address);
		return m;
	}

	
	public boolean insert(Member m) {
		sessionFactory.getCurrentSession().save(m);
		return true;
	}

	public boolean delete(Member m) {
		sessionFactory.getCurrentSession().delete(m);
		return false;
	}

	public boolean update(Member m) {
		sessionFactory.getCurrentSession().update(m);
		return false;
	}

	public List<Member> selectAll() {
		Query<Member> query =sessionFactory.getCurrentSession().createQuery("from Member",Member.class);
		return query.list();
	}
	
	public List<MemberDup> selectAll_registeredMembers() {
		Query<MemberDup> query =sessionFactory.getCurrentSession().createQuery("from MemberDup where isDeleted=0",MemberDup.class);
		return query.list();
	}

	public List<Member> getByApplicationNumber(String appno) {
		String appQuery = "from Member where appNo = :appno";
		Query<Member> query = sessionFactory.getCurrentSession().createQuery(appQuery,Member.class);
		query.setParameter("appno", appno);
		return query.getResultList();
	}

	public List<Member> getByMobileNumber(Long phone) {
		String hql = "from Member mem LEFT JOIN FETCH mem.details where mem.details.phone = :phone";
		Query<Member> q = sessionFactory.getCurrentSession().createQuery(hql, Member.class);
		q.setParameter("phone", phone);
		return q.list();
	}

	public List<Member> getByDistrict(String dis) {
		String hql = "from Member mem left join fetch mem.address where mem.address.district = :dis";
		Query<Member> q = sessionFactory.getCurrentSession().createQuery(hql, Member.class);
		q.setParameter("dis", dis);
		return q.list();
	}

	public List<Member> getByState(String state) {
		String hql = "from Member mem left join fetch mem.address where mem.address.state = :state";
		Query<Member> q = sessionFactory.getCurrentSession().createQuery(hql, Member.class);
		q.setParameter("state", state);
		return q.list();
	}

	public List<Member> getByTaluk(String taluk) {
		String hql = "from Member mem left join fetch mem.address where mem.address.taluk = :taluk";
		Query<Member> q = sessionFactory.getCurrentSession().createQuery(hql, Member.class);
		q.setParameter("taluk", taluk);
		return q.list();
	}

	public List<Member> getByAlphabet(char a) {
		String hql = "from Member m where m.fname like :s";
		Query<Member> q = sessionFactory.getCurrentSession().createQuery(hql, Member.class);
		q.setParameter("s", Character.toString(a) + "%");
		return q.list();
	}

	public List<Member> getByPincode(int pincode) {
		String hql = "from Member mem left join fetch mem.address where mem.address.pincode = :pincode";
		Query<Member> q = sessionFactory.getCurrentSession().createQuery(hql, Member.class);
		q.setParameter("pincode", pincode);
		return q.list();
	}

	public Member getById(String id) {
		return sessionFactory.getCurrentSession().get(Member.class, id);
	}

	public MemberDup getById_registeredMember(String id) {
		return sessionFactory.getCurrentSession().get(MemberDup.class, id);
		
	}

	public boolean insert_registeredMember(MemberDup m) {
		sessionFactory.getCurrentSession().persist(m);
		return false;
	}

	public boolean update(MemberDup m) {
		sessionFactory.getCurrentSession().update(m);
		return true;
	}

	public void insert_user(Users user) {
	
		sessionFactory.getCurrentSession().save(user);
		
	}

	

}