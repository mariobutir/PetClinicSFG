package com.example.sfgpetclinic.services;

import java.util.Set;

import com.example.sfgpetclinic.model.Owner;

public interface OwnerService {

	Owner findByLastName(String lastname);

	Owner findById(Long id);

	Owner save(Owner owner);

	Set<Owner> findAll();

}
