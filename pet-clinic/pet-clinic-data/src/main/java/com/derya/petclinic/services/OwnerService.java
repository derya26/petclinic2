package com.derya.petclinic.services;

import com.derya.petclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long>{
	
	Owner findByLastName(String lastName);
	

}
