package com.carlhuffmeier.petclinic.repositories;

import com.carlhuffmeier.petclinic.models.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    @Override
    Set<Owner> findAll();

    Owner findByLastName(String lastName);
}
