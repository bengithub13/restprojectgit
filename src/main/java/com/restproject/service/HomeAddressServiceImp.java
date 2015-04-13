package com.restproject.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.restproject.dao.AddressDAO;
import com.restproject.domain.HomeAddress;
import com.restproject.dto.AddressesDTO;
import com.restproject.dto.HomeAddressDTO;
import com.restproject.utility.Mapper;


@Service("HomeAddressService")
@ContextConfiguration(locations={"classpath:/META-INF/applicationContext-dbtest.xml"})
//@Component
public class HomeAddressServiceImp implements HomeAddressService, ApplicationContextAware{
/*
 * @Resource – Defined in the javax.annotation package and part of Java
 * if  you want to express annotation injection by name then use @Resource
*@Resource only can support for fields, and bean property setter methods with a single argument.

@Inject – Defined in the javax.inject package and part of Java

@Autowired – Defined in the package org.springframework.bean.factory and part of Spring framework.
autowire  is type matched injection - @qualifier can used to specify bean with the qualifier propetery set in the bean definition
 Autowire can be used to fields, constructors, and multi-argument methods
 * refer to http://docs.spring.io/spring/docs/2.5.x/reference/beans.html#beans-autowired-annotation
 */




@Resource(name="homeAddressDAO")
protected AddressDAO homeAddressDAO;

@Autowired
Mapper<HomeAddress,HomeAddressDTO> homeAddressMapper;
private static ApplicationContext applicationContext;
	

public HomeAddressServiceImp(){
	super();
}

public HomeAddressServiceImp(AddressDAO homeAddressDAO, Mapper<HomeAddress,HomeAddressDTO> homeAddressMapper){
super();
this.homeAddressDAO=homeAddressDAO;
this.homeAddressMapper=homeAddressMapper;
}
	/*
	@Autowired
	public HomeAddressServiceImp(@Qualifier("homeAddressDAO") AddressDAO homeAddressDAO, HomeAddressMapperImpl homeAddressMapper){
	this.homeAddressDAO=homeAddressDAO;
	this.homeAddressMapper=homeAddressMapper;
	}
	*/

	@Transactional
	public AddressesDTO getAllAddressListByZipCode(String zipCode){
	List<HomeAddress> homeAddresslist=homeAddressDAO.findByZipCode(zipCode);
	List<HomeAddressDTO> homeAddressDTOList=new ArrayList<HomeAddressDTO>();
	
		
	for (HomeAddress homeAddress:homeAddresslist){
	HomeAddressDTO homeAddressDTO=new HomeAddressDTO();
	homeAddressMapper.map(homeAddress, homeAddressDTO);
	homeAddressDTOList.add(homeAddressDTO);
	}
	
	return new AddressesDTO(homeAddressDTOList);
	
	}

	public AddressesDTO getAllAddressList() {
		// TODO Auto-generated method stub
		List<HomeAddress> homeAddresslist=homeAddressDAO.findAll();
		List<HomeAddressDTO> homeAddressDTOList=new ArrayList<HomeAddressDTO>();
		
			
		for (HomeAddress homeAddress:homeAddresslist){
		HomeAddressDTO homeAddressDTO=new HomeAddressDTO();
		homeAddressMapper.map(homeAddress, homeAddressDTO);
		homeAddressDTOList.add(homeAddressDTO);
	}
		return new AddressesDTO(homeAddressDTOList);
	}
	


public static void setApplicationContexts(ApplicationContext applicationContexts){
	applicationContext=applicationContexts;
}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		setApplicationContexts(applicationContext);
		
	}

	
	

}
