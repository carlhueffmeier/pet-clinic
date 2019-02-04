package com.carlhuffmeier.petclinic.repositories;

import com.carlhuffmeier.petclinic.models.Speciality;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {


    @Override
    Set<Speciality> findAll();
}
