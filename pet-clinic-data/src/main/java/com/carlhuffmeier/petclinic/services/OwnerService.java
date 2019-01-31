package com.carlhuffmeier.petclinic.services;

import com.carlhuffmeier.petclinic.models.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
