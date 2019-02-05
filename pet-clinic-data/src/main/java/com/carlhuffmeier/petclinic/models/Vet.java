package com.carlhuffmeier.petclinic.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Speciality> specialities = new HashSet<>();

    public void addSpeciality(Speciality speciality) {
        specialities.add(speciality);
    }
}
