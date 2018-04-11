package com.reddy.krjs.supportEnd.Model;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import com.reddy.krjs.supportEnd.dao.MemberDao;

public class EmployeeIdGenerator  implements IdentifierGenerator {

	@Autowired
	MemberDao member;
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		
		//String val = member.getNextVal().getNextVal();
		//val = val.substring(1);
		//int next = Integer.parseInt(val) + 1;
		return "M" + "02";
	}
	
	

}
