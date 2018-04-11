package com.reddy.krjs.supportEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.reddy.krjs.supportEnd.Model.Member;
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
		user.setMemberId("M2018228205447");
		user.setPassword(new BCryptPasswordEncoder().encode("7396"));
		user.setEnable(true);
		user.setRole("ROLE_ADMIN");
		MemberDao mdao = (MemberDao)context.getBean("memberdao");
		mdao.insert_user(user);*/
		

		MemberDao mdao = (MemberDao)context.getBean("memberdao");
		//mdao.insert_code("1232", "M2018228205447");
		
		Member m = mdao.getById("sdjfkj");
		if(m == null)
			System.out.println("null");
		/*		  Random ran = new Random(); 
		  String memid = "M"+ran.nextInt(5);
		  String app = "A" + memid; 
		  MemberDup m  = new MemberDup();
		  m.setAppNo(app);
		  m.setMemberId(memid); 
		  m.setName("vendi");
		  m.setFhname("Rama krishna");
		  m.setTitle("mrs"); 
		  m.setDob(new Date());
		  m.setAadhar("534845484");
		  
		 
		  m.setFhname("daddy");
		  String city[] = { "Bangalore", "Andhra Pradesh", "chennai", "delhi", "mumbai"}; 
		  String pincode[] = { "560068", "500068", "500001", "560075", "520054", "560012" };
		  
		  Address current = new Address();
		  current.setAddress("25/10 1st main");
		  current.setVillage("kormangla"); 
		  
		  current.setState(city[new Random().nextInt(5)]); 
		  current.setTaluk(city[new Random().nextInt(5)]);
		  current.setDistrict(city[new Random().nextInt(5)]);
		  current.setPincode(pincode[new Random().nextInt(5)]);
		  
		  DetailsDup details = new DetailsDup();
		  details.setOccupation("farmer");
		  details.setMaritalStatus(true); details.setNoc(0);
		  details.setVemanaVani(true); details.setMember(m); 
		  details.setPhone("7396880443");
		  details.setGmail("vandu.n7@gmail.com");
		  
		  
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
		  
		  dao.insert_registeredMember(m);*/
		 
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
