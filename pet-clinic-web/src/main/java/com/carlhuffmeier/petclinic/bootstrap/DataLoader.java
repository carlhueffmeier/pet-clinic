package com.carlhuffmeier.petclinic.bootstrap;

import com.carlhuffmeier.petclinic.models.Owner;
import com.carlhuffmeier.petclinic.models.Pet;
import com.carlhuffmeier.petclinic.models.PetType;
import com.carlhuffmeier.petclinic.models.Speciality;
import com.carlhuffmeier.petclinic.models.Vet;
import com.carlhuffmeier.petclinic.models.Visit;
import com.carlhuffmeier.petclinic.services.OwnerService;
import com.carlhuffmeier.petclinic.services.PetTypeService;
import com.carlhuffmeier.petclinic.services.SpecialityService;
import com.carlhuffmeier.petclinic.services.VetService;
import com.carlhuffmeier.petclinic.services.VisitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private VisitService visitService;

    public DataLoader(
            OwnerService ownerService,
            VetService vetService,
            PetTypeService petTypeService,
            SpecialityService specialityService,
            VisitService visitService
    ) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("🐶 Pet types loaded‍");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        System.out.println("💉 Specialities loaded‍");

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("555 123 123");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("555 123 123");

        Pet fionasPet = new Pet();
        fionasPet.setPetType(savedCatPetType);
        fionasPet.setOwner(owner2);
        fionasPet.setBirthDate(LocalDate.now());
        fionasPet.setName("Boxie");
        owner2.getPets().add(fionasPet);

        ownerService.save(owner2);

        System.out.println("👩 Owners loaded‍");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Dean");
        vet2.setLastName("Wight");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("🚑 Vets loaded");

        Visit visit1 = new Visit();
        visit1.setPet(mikesPet);
        visit1.setDate(LocalDate.now());
        visit1.setDescription("Just a checkup");
        visitService.save(visit1);

        Visit visit2 = new Visit();
        visit2.setPet(fionasPet);
        visit2.setDate(LocalDate.now());
        visit2.setDescription("Removing a splinter in Boxie's paw");
        visitService.save(visit2);

        System.out.println("🕐 Visits loaded");
    }
}
