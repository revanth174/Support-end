package com.reddy.krjs.supportEnd.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.reddy.krjs.supportEnd.Model.Address;
import com.reddy.krjs.supportEnd.Model.DetailsDup;
import com.reddy.krjs.supportEnd.Model.MemberDup;
import com.reddy.krjs.supportEnd.Model.PaymentDup;




@Configuration

@EnableTransactionManagement
public class ApplicationContextConfig {

	// data base properties

	private static final String DATABASE_URL1 = "jdbc:mysql://localhost:3306/per?autoReconnect=true&useSSL=false";
	private static final String DATABASE_DIALECT = "org.hibernate.dialect.MySQL5Dialect";
	private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DATABASE_USERNAME = "root";
	private static final String DATABASE_PASSWORD = "7396";

	// datasource is another means of connection database.
	@Autowired
	@Bean(name = "dataSource")
	public DataSource getMysqlDataSource() {

		System.out.println("datasource");
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName(DATABASE_DRIVER);
		datasource.setUrl(DATABASE_URL1);
		datasource.setUsername(DATABASE_USERNAME);
		datasource.setPassword(DATABASE_PASSWORD);
		System.out.println("data source created");
		return datasource;
	}
	
	
	
	
	
	

	// setting hibernate properties
	public Properties getHibernateProperties() {
		System.out.println("Hibernate properties");
		Properties prop = new Properties();
		prop.put("hibernate.dialect", DATABASE_DIALECT);
		//properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		prop.put("hibernate.show_sql", "true");
		prop.put("hibernate.format_sql", "true");
		prop.put("hibernate.hbm2ddl.auto", "update");
		System.out.println("hibernate properties created");
		return prop;
	}
	
	
	
	
	

	// session factory
	// @Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource1) {

		System.out.println("session factory");
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(getMysqlDataSource());
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(MemberDup.class);
		sessionBuilder.scanPackages("com.reddy.krjs.supportEnd.Model");
		sessionBuilder.addAnnotatedClass(DetailsDup.class);
		sessionBuilder.addAnnotatedClass(PaymentDup.class);
		sessionBuilder.addAnnotatedClass(Address.class);
		//sessionBuilder.addAnnotatedClass(Users.class);
		//sessionBuilder.addAnnotatedClass(Student.class);
		System.out.println("session factory object creates");
		return sessionBuilder.buildSessionFactory();
	}
	
	
	
	@Autowired
	@Bean("Transactional")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		System.out.println("in transaction manager");
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("returns trasaction manager");
		return transactionManager;
		
	}
	
	
	@Bean("encoder")
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
}
