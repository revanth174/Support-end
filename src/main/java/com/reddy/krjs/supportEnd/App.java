package com.reddy.krjs.supportEnd;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.reddy.krjs.supportEnd.Model.Address;
import com.reddy.krjs.supportEnd.Model.DetailsDup;
import com.reddy.krjs.supportEnd.Model.MemberDup;
import com.reddy.krjs.supportEnd.Model.PaymentDup;
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

		/*Users user = new Users();
		user.setMemberId("revanth");
		user.setPassword(new BCryptPasswordEncoder().encode("7396"));
		user.setEnable(true);
		user.setRole("USER");
		MemberDao mdao = (MemberDao)context.getBean("memberdao");
		mdao.insert_user(user);*/
		

		
		 Random ran = new Random(); String memid = "M" + Integer.toString(ran.nextInt(100000));
		 String app = "A" + memid; 
		 MemberDup m  = new MemberDup(); m.setAppNo(app); m.setMemberId(memid); m.setName("veena");
		  String a[] =
		  {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s",
		  "t","u","v","w","x","y","z"}; m.setFname(a[ran.nextInt(26)]);
		  m.setTitle("mrs"); int yyyy = 1996; int mm = 10; int date = 30; 
		 // year-month-date m.setDob(LocalDate.of(yyyy, mm, date));
		  
		  String city[] = { "Bangalore", "Andhra Pradesh", "chennai", "delhi", "mumbai"
		  }; int pincode[] = { 560068, 500068, 500001, 560075, 520054, 560012 };
		  
		  Address current = new Address(); current.setAddress("25/10 1st main");
		  current.setCity("kormangla"); current.setState(city[new
		  Random().nextInt(5)]); current.setTaluk(city[new Random().nextInt(5)]);
		  current.setDistrict(city[new Random().nextInt(5)]);
		  current.setPincode(pincode[new Random().nextInt(5)]);
		  
		  DetailsDup details = new DetailsDup(); details.setOccupation("farmer");
		  details.setMaritalStatus(true); details.setNoc(0);
		  details.setVemanaVani(true); details.setMember(m); details.setPhone(123456l);
		  
		  details.setQualification("degree");
		  
		  PaymentDup payment = new PaymentDup();
		  
		  payment.setFeePaid(BigDecimal.valueOf(1000.0)); String ref = "ref" +
		  Integer.toString(new Random().nextInt(10000)); payment.setRefNo(ref);
		  payment.setMop("online"); payment.setApplicationDate(new Date());
		  payment.setMember(m);
		  
		  m.setAddress(current); m.setDetails(details); m.setPayment(payment); //
		  System.out.println("hello");
		  
		  System.out.println(m);
		  
		  MemberDao mdao = (MemberDao)context.getBean("memberdao"); //MemberDup me =
		  new MemberDup();
		  
		  mdao.insert_registeredMember(m);
		 
		/*
		 * MemberDup mem = mdao.getById_registeredMember("M73270");
		 * System.out.println(mem.getMemberId());
		 */

	}
}
