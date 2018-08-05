package com.example.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.sfgpetclinic.model.Owner;
import com.example.sfgpetclinic.model.Pet;
import com.example.sfgpetclinic.services.OwnerService;
import com.example.sfgpetclinic.services.PetService;
import com.example.sfgpetclinic.services.PetTypeService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

	private final PetTypeService petTypeService;
	private final PetService petService;

	public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {

		this.petTypeService = petTypeService;
		this.petService = petService;
	}

	@Override
	public Owner save(Owner object) {

		if (object != null) {
			if (object.getPets() != null) {
				object.getPets().forEach(pet -> {
					if (pet.getPetType() != null) {
						if (pet.getPetType().getId() == null) {
							pet.setPetType(petTypeService.save(pet.getPetType()));
						}
					} else {
						throw new RuntimeException("Pet Type is required");
					}

					if (pet.getId() != null) {
						Pet savedPet = petService.save(pet);
						pet.setId(savedPet.getId());
					}
				});
			}

			return super.save(object);
		} else {
			return null;
		}
	}

	@Override
	public void delete(Owner object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}

	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Owner findByLastName(String lastname) {
		return null;
	}

}
