package com.example.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.sfgpetclinic.model.Owner;
import com.example.sfgpetclinic.model.Vet;
import com.example.sfgpetclinic.services.OwnerService;
import com.example.sfgpetclinic.services.VetService;
import com.example.sfgpetclinic.services.map.OwnerServiceMap;
import com.example.sfgpetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

	private OwnerService ownerService;
	private VetService vetService;

	public DataLoader() {
		this.ownerService = new OwnerServiceMap();
		this.vetService = new VetServiceMap();
	}

	@Override
	public void run(String... args) throws Exception {

		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirstName("Milan");
		owner1.setLastName("Mileni");

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setId(2L);
		owner2.setFirstName("Luka");
		owner2.setLastName("Lekić");

		ownerService.save(owner2);

		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setFirstName("Lovro");
		vet1.setLastName("Lovren");

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setId(2L);
		vet2.setFirstName("Toni");
		vet2.setLastName("Torba");

		vetService.save(vet2);
	}

}
