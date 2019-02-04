package com.carlhuffmeier.petclinic.repositories;

import com.carlhuffmeier.petclinic.models.PetType;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

    @Override
    Set<PetType> findAll();
}
