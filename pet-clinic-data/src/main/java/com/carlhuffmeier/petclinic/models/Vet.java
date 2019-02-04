package com.carlhuffmeier.petclinic.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Speciality> specialities = new HashSet<>();

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void addSpeciality(Speciality speciality) {
        specialities.add(speciality);
    }
}
