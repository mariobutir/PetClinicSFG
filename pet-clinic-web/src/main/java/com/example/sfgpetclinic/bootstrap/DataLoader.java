package com.example.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.sfgpetclinic.model.Owner;
import com.example.sfgpetclinic.model.Pet;
import com.example.sfgpetclinic.model.PetType;
import com.example.sfgpetclinic.model.Speciality;
import com.example.sfgpetclinic.model.Vet;
import com.example.sfgpetclinic.services.OwnerService;
import com.example.sfgpetclinic.services.PetTypeService;
import com.example.sfgpetclinic.services.SpecialitiesService;
import com.example.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialitiesService specialitiesService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialitiesService specialitiesService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialitiesService = specialitiesService;
	}

	@Override
	public void run(String... args) throws Exception {

		int count = petTypeService.findAll().size();
		if (count == 0) {
			loadData();
		}
	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Doge");
		PetType savedDogPetType = petTypeService.save(dog);

		PetType cat = new PetType();
		dog.setName("Cate");
		PetType savedCatPetType = petTypeService.save(cat);

		Speciality radiology = new Speciality();
		radiology.setDescription("Radiology");
		Speciality savedRadiology = specialitiesService.save(radiology);

		Speciality surgery = new Speciality();
		surgery.setDescription("Surgery");
		Speciality savedSurgery = specialitiesService.save(surgery);

		Speciality dentistry = new Speciality();
		dentistry.setDescription("Dentistry");
		Speciality savedDentistry = specialitiesService.save(dentistry);

		Owner owner1 = new Owner();
		owner1.setFirstName("Milan");
		owner1.setLastName("Mileni");
		owner1.setAddress("Ilica 123");
		owner1.setCity("Zagreb");
		owner1.setTelephone("092212212");

		Pet milanovPet = new Pet();
		milanovPet.setPetType(savedDogPetType);
		milanovPet.setName("Frane");
		milanovPet.setBirthDate(LocalDate.now());
		milanovPet.setOwner(owner1);
		owner1.getPets().add(milanovPet);

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Luka");
		owner2.setLastName("Lekić");
		owner1.setAddress("Ilica 213");
		owner1.setCity("Zagreb");
		owner1.setTelephone("092131231");

		Pet lukinPet = new Pet();
		lukinPet.setPetType(savedCatPetType);
		lukinPet.setName("Mate");
		lukinPet.setBirthDate(LocalDate.now());
		lukinPet.setOwner(owner2);
		owner2.getPets().add(lukinPet);

		ownerService.save(owner2);
		System.out.println("Loading owners...");

		Vet vet1 = new Vet();
		vet1.setFirstName("Lovro");
		vet1.setLastName("Lovren");
		vet1.getSpecialities().add(savedRadiology);

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Toni");
		vet2.setLastName("Torba");
		vet2.getSpecialities().add(savedSurgery);

		vetService.save(vet2);
		System.out.println("Loading vets...");
	}

}
