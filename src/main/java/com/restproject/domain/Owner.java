package com.restproject.domain;



import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="owner")
@SequenceGenerator(name=AbstractDomain.GENERATED_VALUE_STRATEGY,sequenceName="OWNER_SEQ")
public class Owner extends AbstractDomain {

	private static final long serialVersionUID=2l;
@Column(name="first_name")
private String firstName;

@Column(name="last_name")
private String lastName;


//@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
@JoinTable(name="OWNER_ADDRESS_PIVOT",
joinColumns={@JoinColumn(name="OWNER_FK")},
inverseJoinColumns={@JoinColumn(name="ADDRESS_FK")})
private Set<HomeAddress> addressSet;


public String getFirstName(){
return this.firstName;
}

public void setFirstName(String firstName){
this.firstName=firstName;	
}

public String getLastName(){
return this.lastName;
}

public void setLastName(String lastName){
this.lastName=lastName;	
}



public Set<HomeAddress> getHomAddress() {  
    return addressSet;  
}  


public void setAddress(Set<HomeAddress> addressSet) {  
    this.addressSet = addressSet;  
} 


	

}
