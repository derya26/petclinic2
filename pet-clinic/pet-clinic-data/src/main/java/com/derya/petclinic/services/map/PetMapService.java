package com.derya.petclinic.services.map;

import org.springframework.stereotype.Service;

import com.derya.petclinic.model.Pet;
import com.derya.petclinic.services.PetService;

@Service
public class PetMapService extends AbstractMapService<Pet, Long>implements PetService{

	@Override
	public Pet save(Pet object) {
		
		return super.save( object);
	}

}
