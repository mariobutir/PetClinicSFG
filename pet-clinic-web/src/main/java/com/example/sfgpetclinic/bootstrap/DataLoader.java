package com.example.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.sfgpetclinic.model.Owner;
import com.example.sfgpetclinic.model.Vet;
import com.example.sfgpetclinic.services.OwnerService;
import com.example.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;

	public DataLoader(OwnerService ownerService, VetService vetService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
	}

	@Override
	public void run(String... args) throws Exception {

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
