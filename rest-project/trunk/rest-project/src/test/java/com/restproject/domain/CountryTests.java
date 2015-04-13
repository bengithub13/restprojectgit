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
// @TestExecutionListeners(TransactionalTestExecutionListener.class)
// DependencyInjectionTestExecutionListener.class,
// ServletTestExecutionListener.class})
@Transactional
// public class CountryTests extends
// AbstractTransactionalJUnit4SpringContextTests{
@ContextConfiguration(locations = { "classpath:/META-INF/applicationContext.xml" })
public class CountryTests extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	protected SessionFactory sessionFactory;
	protected Country country;

	// log4j native logger code
	//tatic final Logger logger=Logger.getLogger(CountryTests.class);
	static Logger logger=LoggerFactory.getLogger(CountryTests.class);
	@Before
	public void setUp() throws Exception {
		logger.info("Test beginning");
		Session session=SessionFactoryUtils.getSession(sessionFactory,false);	
		country = new Country();
		country.setId(500L);
		country.setCountry("china");
		country.setDate();

		HomeAddress address1 = new HomeAddress();
		address1.setId(500l);
		address1.setAddress("79 Foch Ave");
		address1.setZipCode("10305");
		address1.setCountry(country);
		HomeAddress address2 = new HomeAddress();
		address2.setId(501l);
		address2.setAddress("11420 Queens Blvd");
		address2.setZipCode("11375");
		address2.setCountry(country);

		Set<HomeAddress> homeAddresses = new HashSet<HomeAddress>();
		homeAddresses.add(address1);
		homeAddresses.add(address2);

		country.setAddress(homeAddresses);
		session.flush();
		session.save(country);
	}

	@Test
	 //@Rollback(false)
	public void test() {
		//BasicConfigurator.configure();   log4j native intialization
		logger.info("Testing");
		Country loaded = (Country) sessionFactory.getCurrentSession().get(
				Country.class, country.getId());
		assertNotNull(loaded);
	}

}
		