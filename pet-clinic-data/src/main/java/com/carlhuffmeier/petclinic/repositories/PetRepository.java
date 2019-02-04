package com.carlhuffmeier.petclinic.repositories;

import com.carlhuffmeier.petclinic.models.Pet;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface PetRepository extends CrudRepository<Pet, Long> {

    @Override
    Set<Pet> findAll();
}
