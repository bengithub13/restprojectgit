package com.restproject.domain;



import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
@Entity
@NamedQueries({
	@NamedQuery(name="com.restproject.domain.HomeAddress.findByZipCode",query="from HomeAddress a where a.zipCode=?"),
	@NamedQuery(name="com.restproject.domain.HomeAddress.findAll",query="from HomeAddress a")})


@Table(name="address")
@SequenceGenerator(name=AbstractDomain.GENERATED_VALUE_STRATEGY,sequenceName="ADDRESS_SEQ")
public class HomeAddress extends AbstractDomain{
	private static final long serialVersionUID=2l;
	

@Column(name="street")
private String street;

@Column(name="zip_code")
private String zipCode;

@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
@JoinColumn(name="country_fk",nullable=false)
//Many addresses per one country..each  country can be in many addresses,
private Country country;

//@PrimaryKeyJoinColumn
//@JoinColumn(name="country_fk")


// ARTICLE ABOUT LAZY LOADING  WHICH BY NATURE RETURNS A PROXY OBJECT IN PLACE OF THE RELATED OBJECT THAT IS LAZY LOADED.  IF THE SESSION IS CLOSED
// AND LATER WE TRY TO ACCESS THE ATTRIBUTES OF THE PARENT OBJECT..THE CONNECTION IS ALREADY CLOSED AND WE WILL GET A
//org.hibernate.LazyInitializationException: could not initialize proxy - no Session EXCEPTION
//http://javarevisited.blogspot.com/2014/04/orghibernatelazyinitializationException-Could-not-initialize-proxy-no-session-hibernate-java.html

//@ManyToMany(fetch=FetchType.EAGER,mappedBy="addressSet",cascade=CascadeType.ALL)
//private Set<Owner> owners;


public String getStreet(){
return this.street;
}

public void setAddress(String street){
this.street=street;	
}


public String getZipCode(){
return this.zipCode;
}

public void setZipCode(String zipCode){

this.zipCode= zipCode;


}

public void setCountry(Country country){
	
	this.country=country;
	
}
public Country getCountry(){
	
return this.country;
	
}

public Set<Owner> getOwner() {  
   // return owners; 
	return null;
}  


public void setOwner(Set<Owner> owners) {  
   // this.owners = owners;  
}  

}
