package com.restproject.resource;

import javax.ws.rs.GET;





import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.restproject.dto.AddressesDTO;
import com.restproject.service.HomeAddressServiceImp;
//@Path("HomeAddress")
@Controller("homeaddress")
public class HomeAddressResourceImpl implements HomeAddressResource{
	

@Autowired
HomeAddressServiceImp homeAddressService;

public AddressesDTO getAllAddressesByZip(String zipCode) {
	Logger.getRootLogger().info("all address lookup for a zipcode");
	return homeAddressService.getAllAddressListByZipCode(zipCode);	
}


public AddressesDTO getAllAddresses(String zipcode){
	Logger.getRootLogger().info("all address lookup all zipcodes");
	return homeAddressService.getAllAddressListByZipCode("11040");	
	}
}
