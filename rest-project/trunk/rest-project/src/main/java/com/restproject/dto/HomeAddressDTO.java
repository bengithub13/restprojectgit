package com.restproject.dto;


import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.restproject.domain.Owner;



@XmlRootElement(name="address")
public class HomeAddressDTO {
private String street;
private String zipCode;
private Set<Owner> owners;

@XmlElement(name="street_name")
public String getStreet(){
return this.street;
}

public void setStreet(String street){
	this.street=street;
}

@XmlElement(name="zipcode")
public String getZipCode(){
return this.zipCode;
}

public void setZipCode(String zipCode){
	this.zipCode=zipCode;
}

@XmlElementWrapper(name="owners")
@XmlElement(name="owner")
public Set<Owner> getOwners(){
	return this.owners;
}

public void setOwners(Set<Owner> owners){
this.owners=owners;
}
}