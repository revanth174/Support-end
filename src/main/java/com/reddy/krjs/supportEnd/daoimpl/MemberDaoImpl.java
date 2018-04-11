package com.reddy.krjs.supportEnd.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.reddy.krjs.supportEnd.Model.Address;
import com.reddy.krjs.supportEnd.Model.Details;
import com.reddy.krjs.supportEnd.Model.Emp;
import com.reddy.krjs.supportEnd.Model.Gen_Seq;
import com.reddy.krjs.supportEnd.Model.Member;
import com.reddy.krjs.supportEnd.Model.MemberDup;
import com.reddy.krjs.supportEnd.Model.Payment;
import com.reddy.krjs.supportEnd.Model.Users;
import com.reddy.krjs.supportEnd.Model.Ward;
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
		//m.setDob(member.getDob());
		
		m.setGender(member.getGender());
		m.setName(member.getName());
		m.setTitle(member.getTitle());
		m.setType(member.getType());
		m.setFhname(member.getFhname());
		m.setDob(member.getDob());
		m.setProposerMemberId(member.getProposerMemberId());
		m.setProposerName(member.getProposerName());
		m.setProposerPhoneNumber(member.getProposerPhoneNumber());
		m.setAadhar(member.getAadhar());
		m.setPan(member.getPan());
		m.setVoter(member.getVoter());
		
		
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
		
		payment.setRefNo(member.getPayment().getRefNo());
		payment.setMember(m);
		
		
		Address address = new Address();
		address.setAddress(member.getAddress().getAddress());
		address.setVillage(member.getAddress().getVillage());
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
		//sessionFactory.getCurrentSession().saveOrUpdate(m);
		String id = m.getMemberId();
		int n = Integer.parseInt(id.substring(1));
		n++;
		id = "M" + n;
		Gen_Seq g = new Gen_Seq();
		g.setNextVal(id);
		sessionFactory.getCurrentSession().save(g);
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
	
	public List<MemberDup> selectAll_registeredMembers(boolean a) {
		Query<MemberDup> query =sessionFactory.getCurrentSession().createQuery("from MemberDup where isDeleted=:a",MemberDup.class)
				.setParameter("a", a);
		return query.list();
	}

	public List<Member> getByApplicationNumber(String appno) {
		String appQuery = "from Member where appNo = :appno";
		Query<Member> query = sessionFactory.getCurrentSession().createQuery(appQuery,Member.class);
		query.setParameter("appno", appno);
		return query.getResultList();
	}

	public List<Member> getByMobileNumber(String phone) {
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

	public List<Member> getByPincode(String pincode) {
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

	@Override
	public void insert_code(String  code, String id) {
		Users user = sessionFactory.getCurrentSession().get(Users.class,id);
		user.setCode(code);
		sessionFactory.getCurrentSession().update(user);
		
	}
	
	
	public boolean checkCode(String code,String id) {
		Users user = sessionFactory.getCurrentSession().get(Users.class,id);
		if(user.getCode().equals(code))
			return true;
		
		else return false;
	}
	
	public boolean changeUserPassword(String code,String id) {
		Users user = sessionFactory.getCurrentSession().get(Users.class,id);
		user.setPassword(new BCryptPasswordEncoder().encode(code));
		sessionFactory.getCurrentSession().update(user);
		return true;

	}

	@Override
	public void addWard(Ward  ward) {
		
		sessionFactory.getCurrentSession().save(ward);
	}

	@Override
	public List<Ward> listOfWards() {
		String hql = "from Ward";
		Query<Ward> wardlist = sessionFactory.getCurrentSession().createQuery(hql,Ward.class);
		return wardlist.list();
	}

	/*public Gen_Seq getNextVal() {
		return sessionFactory.getCurrentSession().get(Gen_Seq.class,1);
	}*/
	
	public void insertEmp(Emp e) {
		sessionFactory.getCurrentSession().save(e);
		
	}

	

}
