package com.restproject.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
@Controller
public class HomeAddressControllerImpl implements HomeAddressController {

	@Override
	public String getAllAddresses(ModelMap model) {
		model.addAttribute("message", "Spring MVC AllAddress");
		return "helloWorld";
	}

	@Override
	public String getAllAddressesByZip(String zipCode, ModelMap model) {
		model.addAttribute("message", "Spring MVC Address by Zipcode");
		return "helloWorld";
	}

	@Override
	public String getAllAddressesByStreet(String street, ModelMap model) {
		model.addAttribute("message", "Spring 3 address by Street");
		return "helloWorld";
	}

}
