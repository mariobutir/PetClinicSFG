package com.example.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.sfgpetclinic.model.Speciality;
import com.example.sfgpetclinic.model.Vet;
import com.example.sfgpetclinic.services.SpecialitiesService;
import com.example.sfgpetclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

	private final SpecialitiesService specialitiesService;
	

	public VetServiceMap(SpecialitiesService specialitiesService) {
	this.specialitiesService = specialitiesService;
}
@Override
	public Vet save(Vet object) {

		if (object.getSpecialities().size() > 0) {
			object.getSpecialities().forEach(speciality -> {
				if (speciality.getId() == null) {
					Speciality savedSpeciality = specialitiesService.save(speciality);
					speciality.setId(savedSpeciality.getId());
				}
			});
		}
		return super.save(object);
	}

	@Override
	public void delete(Vet object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}

	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

}
