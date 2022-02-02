package com.derya.petclinic.services.map;

import org.springframework.stereotype.Service;

import com.derya.petclinic.model.Vet;
import com.derya.petclinic.services.VetService;

@Service
public class VetMapService extends AbstractMapService<Vet, Long>implements VetService{

	@Override
	public Vet save(Vet object) {
		
		return super.save( object);
	}

}
