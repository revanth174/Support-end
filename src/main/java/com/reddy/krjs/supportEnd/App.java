package com.reddy.krjs.supportEnd;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.reddy.krjs.supportEnd.Model.Address;
import com.reddy.krjs.supportEnd.Model.DetailsDup;
import com.reddy.krjs.supportEnd.Model.MemberDup;
import com.reddy.krjs.supportEnd.Model.PaymentDup;
import com.reddy.krjs.supportEnd.Model.Users;
import com.reddy.krjs.supportEnd.dao.MemberDao;

/**
 * Hello world!
 *
 */
public class App {
	private static AnnotationConfigApplicationContext context;

	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.reddy.krjs.supportEnd");
		context.refresh();

//		Users user = new Users();
//		user.setMemberId(102);
//		user.setPassword(new BCryptPasswordEncoder().encode("7396"));
//		user.setEnable(true);
//		user.setRole("ROLE_ADMIN");
		/*MemberDao mdao = (MemberDao)context.getBean("memberdao");
		mdao.getAdmins().forEach( i -> mdao.getIdAndName(i) );*/
	//	mdao.insert_user(user);
		
		/*Emp e = new Emp();
		e.setFirstname("kjdfhk");
		e.setEmployeeId(7557);
		

		MemberDao mdao = (MemberDao)context.getBean("memberdao");
		int a = mdao.insertEmp(e);
		System.out.println(a);*/
		MemberDao mdao = (MemberDao)context.getBean("memberdao");
		mdao.getBySDT("mumbai", "delhi", "chennai").forEach(System.out::println);
		//mdao.insert_code("1232", "M2018228205447");
		Calendar calendar = new GregorianCalendar();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY); // 24 hour clock
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		int appno =year + month + day + hourOfDay + minute + second;
		int memid = year + month + day + hourOfDay + minute + second;
	    
				Random ran = new Random(); 
		  
		
		  MemberDup m  = new MemberDup();
		  m.setAppNo(ran.nextInt(1000000));
		  m.setMemberId(ran.nextInt(1000000)); 
		  m.setName(" amith");
		  m.setFhname("gopal");
		  m.setTitle("mr"); 
		  m.setDob(new Date());
		  m.setAadhar("534845484");
		  m.setProposerMemberId("102");
		 
		  
		  String city[] = { "Bangalore", "Andhra Pradesh", "chennai", "delhi", "mumbai"}; 
		  String pincode[] = { "560068", "500068", "500001", "560075", "520054", "560012" };
		  
		  Address current = new Address();
		  current.setAddress("25/10 1st main");
		  current.setVillage("kormangla"); 
		  
		  current.setState("Karnataka");//city[new Random().nextInt(5)]); 
		  current.setTaluk("Anekal");//city[new Random().nextInt(5)]);
		  current.setDistrict("Bangalore");//city[new Random().nextInt(5)]);
		  current.setPincode(pincode[new Random().nextInt(5)]);
		  
		  DetailsDup details = new DetailsDup();
		  details.setOccupation("farmer");
		  details.setMaritalStatus(true); details.setNoc(0);
		  details.setVemanaVani(true); details.setMember(m); 
		  details.setPhone("7396880443");
		  details.setGmail("poojinvr@gmail.com");
		  
		  
		  details.setQualification("degree");
		  
		  PaymentDup payment = new PaymentDup();
		  
		  payment.setFeePaid(BigDecimal.valueOf(1000.0)); 
		  String ref = "ref" +  Integer.toString(new Random().nextInt(10000));
		  payment.setRefNo(ref);
		  payment.setMop("online"); payment.setApplicationDate(new Date());
		  payment.setMember(m);
		  
		  m.setAddress(current); m.setDetails(details); m.setPayment(payment); //
		  System.out.println("hello");
		  
		  System.out.println(m);
		  
		  MemberDao dao = (MemberDao)context.getBean("memberdao"); 
		  
		  dao.insert_registeredMember(m);
		 
		 /*MemberDao dao = (MemberDao)context.getBean("memberdao");
		  Member member = dao.getById("M2018229182922");
		  if(member != null)
		  System.out.println(member.getMemberId());
		  else
			  System.out.println("no member");
		  Member m = new Member();
		  m.setMemberId("M2018229182922");
		  
		  Payment p = member.getPayment();
			Details d = member.getDetails();
			p.setMember(member);
			d.setMember(member);
			member.setPayment(p);
			member.setDetails(d);
		  dao.update(member);*/
		 

	}
}
