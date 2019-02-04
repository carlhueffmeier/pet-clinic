package com.carlhuffmeier.petclinic.repositories;

import com.carlhuffmeier.petclinic.models.Vet;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface VetRepository extends CrudRepository<Vet, Long> {

    @Override
    Set<Vet> findAll();
}
