package com.example.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.sfgpetclinic.model.Owner;
import com.example.sfgpetclinic.model.PetType;
import com.example.sfgpetclinic.model.Vet;
import com.example.sfgpetclinic.services.OwnerService;
import com.example.sfgpetclinic.services.PetTypeService;
import com.example.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		PetType dog = new PetType();
		dog.setName("Doge");
		PetType savedDogPetTyoe = petTypeService.save(dog);
		
		PetType cat = new PetType();
		dog.setName("Cate");
		PetType savedCatPetTyoe = petTypeService.save(cat);

		Owner owner1 = new Owner();
		owner1.setFirstName("Milan");
		owner1.setLastName("Mileni");

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Luka");
		owner2.setLastName("Lekić");

		ownerService.save(owner2);
		System.out.println("Loading owners...");

		Vet vet1 = new Vet();
		vet1.setFirstName("Lovro");
		vet1.setLastName("Lovren");

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Toni");
		vet2.setLastName("Torba");

		vetService.save(vet2);
		System.out.println("Loading vets...");
	}

}
