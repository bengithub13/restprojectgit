package com.restproject.domain;

import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.transaction.annotation.Transactional;


//@RunWith(SpringJUnit4ClassRunner.class)

@Transactional

@ContextConfiguration(locations = { "classpath:/META-INF/applicationContext.xml" })
public class OwnerAddressTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	protected SessionFactory sessionFactory;
	protected Owner owner1 ;
	protected Owner owner2 ;
	protected Owner owner3;
	protected Set<Owner> owners1 =new HashSet<Owner>();
	protected Set<Owner> owners2 =new HashSet<Owner>();
	
	protected HomeAddress address1;
	protected HomeAddress address2;
	protected HomeAddress address3;
	protected Set<HomeAddress> addresses1=new HashSet<HomeAddress>();;
	protected Set<HomeAddress> addresses2=new HashSet<HomeAddress>();;
	protected Country country;
	
	// log4j native logger code
	//tatic final Logger logger=Logger.getLogger(CountryTests.class);
	static Logger logger=LoggerFactory.getLogger(CountryTests.class);
	@Before
	public void setUp() throws Exception {
		logger.info("Test beginning");
		Session session = SessionFactoryUtils.getSession(sessionFactory, false);
		owner1 = new Owner();
		owner1.setId(600L);
		owner1.setFirstName("Ben");
		owner1.setLastName("Poon");
		owner2 = new Owner();
		owner2.setId(601L);
		owner2.setFirstName("Gina");
		owner2.setLastName("Wong");
		owner3 = new Owner();
		owner3.setId(602L);
		owner3.setFirstName("Kathy");
		owner3.setLastName("Poon");
		owners1.add(owner1);
		owners1.add(owner2);
		owners2.add(owner3);
		
		//country=new Country();
		//country.setId(220l);
		//country.setCountry("United States");
		//country.setDate();
		
		country= (Country)sessionFactory.getCurrentSession().get(Country.class, 600L);
		
		address1=new HomeAddress();
		address1.setId(600l);
		address1.setAddress("79 Foch Ave");
		address1.setZipCode("10305");	
		address1.setOwner(owners2);		
	    address1.setCountry(country);
	    address2=new HomeAddress();
	    address2.setId(601l);
		address2.setAddress("11420 Queens Blvd");
		address2.setZipCode("11375");
		address2.setOwner(owners1);
		address2.setCountry(country);
		address3=new HomeAddress();
		address3.setId(602l);
		address3.setAddress("29 Michael Lane");
		address3.setZipCode("11040");
		address3.setOwner(owners1);
		address3.setCountry(country);
		

		
		addresses1.add(address2);
		addresses1.add(address3);
		addresses2.add(address1);
		
		
//		session.save(address1);
//		session.save(address2);
//		session.save(address3);
		
		owner1.setAddress(addresses1);
		owner2.setAddress(addresses1);
		owner3.setAddress(addresses2);
		
		session.flush();
		session.save(owner1);
		session.save(owner2);
		session.save(owner3);
	}

	@Test
	 @Rollback(false)
	public void test() {
		//BasicConfigurator.configure();   log4j native intialization
		logger.info("Testing");
		Owner loaded = (Owner) sessionFactory.getCurrentSession().get(
				Owner.class, owner1.getId());
		assertNotNull(loaded);
	}

}

