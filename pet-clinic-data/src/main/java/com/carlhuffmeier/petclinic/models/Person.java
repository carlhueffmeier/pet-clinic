package com.carlhuffmeier.petclinic.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class Person extends BaseEntity {

    private String firstName;
    private String lastName;
}
