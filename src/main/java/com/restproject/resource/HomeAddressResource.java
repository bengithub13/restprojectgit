package com.restproject.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.restproject.dto.AddressesDTO;



//http://localhost:8181/rest-project/services/HomeAddress/11040
@Path("/HomeAddress")
@Produces({"application/xml", "application/json"})
	public interface HomeAddressResource  {
	    
    @GET
	@Path("/all")
    @Produces("application/xml")
    AddressesDTO getAllAddresses(String zipcode);
 
	
	    @GET
		//@Path("/zipcode/{zipCode}")
	   
	@Produces("application/json")    
	  @Path("/{zipCode}")
	    AddressesDTO getAllAddressesByZip(@PathParam("zipCode") String zipCode);
	}
	 



