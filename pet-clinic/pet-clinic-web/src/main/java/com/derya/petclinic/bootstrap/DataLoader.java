package com.derya.petclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.derya.petclinic.model.Owner;
import com.derya.petclinic.model.Pet;
import com.derya.petclinic.model.PetType;
import com.derya.petclinic.model.Vet;
import com.derya.petclinic.services.OwnerService;
import com.derya.petclinic.services.PetTypeService;
import com.derya.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	
	private final VetService vetService;
	
	private final PetTypeService petTypeService;
	

	public DataLoader(OwnerService ownerService,VetService vetService, PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}



	@Override
	public void run(String... args) throws Exception {
		
		PetType dog= new PetType();
		dog.setName("Dog");		
		PetType savedDogType=petTypeService.save(dog);
		
		PetType cat= new PetType();
		cat.setName("Cat");		
		PetType savedCatType=petTypeService.save(cat);
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		owner1.setAddress("123 Brickerel");
		owner1.setCity("Miami");
		owner1.setTelephone("123658898");
		
		Pet mikesPet=new Pet();
		mikesPet.setPetType(savedDogType);
		mikesPet.setOwner(owner1);
		mikesPet.setBirthDate(LocalDate.now());
		mikesPet.setName("Rosco");
		owner1.getPets().add(mikesPet);
		
		ownerService.save(owner1);
		
		Owner owner2= new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");
		owner2.setAddress("654 dfghj");
		owner2.setCity("sdfghjk");
		owner2.setTelephone("354558666");
		
		Pet fionasCat = new Pet();
		fionasCat.setName("Just cat");
		fionasCat.setOwner(owner2);
		fionasCat.setBirthDate(LocalDate.now());
		fionasCat.setPetType(savedCatType);
		owner2.getPets().add(fionasCat);
		
		ownerService.save(owner2);
		
		System.out.println("Loaded owners...");
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
		
		vetService.save(vet2);
		
		System.out.println("Loaded vets...");
	}

}
