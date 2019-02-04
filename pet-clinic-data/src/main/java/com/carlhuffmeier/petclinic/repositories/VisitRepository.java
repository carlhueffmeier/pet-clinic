package com.carlhuffmeier.petclinic.repositories;

import com.carlhuffmeier.petclinic.models.Visit;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface VisitRepository extends CrudRepository<Visit, Long> {

    Set<Visit> findAll();
}
