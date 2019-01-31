package com.carlhuffmeier.petclinic.bootstrap;

import com.carlhuffmeier.petclinic.models.Owner;
import com.carlhuffmeier.petclinic.models.Vet;
import com.carlhuffmeier.petclinic.services.OwnerService;
import com.carlhuffmeier.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");

        ownerService.save(owner2);

        System.out.println("🐶👩 Owners loaded‍");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Dean");
        vet2.setLastName("Wight");

        vetService.save(vet2);

        System.out.println("🐶🚑 Vets loaded");

    }
}
