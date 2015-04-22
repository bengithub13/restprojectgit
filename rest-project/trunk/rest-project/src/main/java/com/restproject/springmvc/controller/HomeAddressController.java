package com.restproject.springmvc.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.restproject.dto.AddressesDTO;

//http://localhost:8181/rest-project/services/HomeAddress/11040

@RequestMapping("/HomeAddress")
public interface HomeAddressController {

	@RequestMapping(value="/all",method = RequestMethod.GET)
	String getAllAddresses(ModelMap model);

	@RequestMapping(value="/zipCode",method = RequestMethod.GET)
	String getAllAddressesByZip(@RequestParam("zipCode") String zipCode, ModelMap model);

	@RequestMapping(value="/street",method = RequestMethod.GET)
	String getAllAddressesByStreet(@RequestParam("street") String street, ModelMap model);
}
