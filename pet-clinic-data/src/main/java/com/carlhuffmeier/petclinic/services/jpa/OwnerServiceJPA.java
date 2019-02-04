package com.carlhuffmeier.petclinic.services.jpa;

import com.carlhuffmeier.petclinic.models.Owner;
import com.carlhuffmeier.petclinic.repositories.OwnerRepository;
import com.carlhuffmeier.petclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("data-jpa")
public class OwnerServiceJPA implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerServiceJPA(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        return ownerRepository.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }
}
