package com.example.mabank;

import com.example.mabank.dao.ClientRepository;
import com.example.mabank.dao.CompteRepository;
import com.example.mabank.dao.OperationRepository;
import com.example.mabank.entities.Client;
import com.example.mabank.entities.CompteCourant;
import com.example.mabank.entities.CompteEpargne;
import com.example.mabank.entities.Versement;
import com.example.mabank.entities.Retrait;
import com.example.mabank.service.IBanqueMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;

@SpringBootApplication
public class MaBankApplication{// implements CommandLineRunner {
/*
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private IBanqueMetier banqueMetier;
*/
    public static void main(String[] args) {
        SpringApplication.run(MaBankApplication.class, args);
    }/*

    @Override
    public void run(String... args) throws Exception {
        // Votre code d'initialisation ici
        Client c1 = new Client("kholoud", "badaoui@gmail.com");
        Client c2 = new Client("Hiba", "benjelloun@gmail.com");
        clientRepository.save(c1);
        clientRepository.save(c2);

        // Sauvegarde des comptes
        CompteCourant cp1 = new CompteCourant("c1", new Date(), 90000, c1, 6000);
        CompteEpargne cp2 = new CompteEpargne("c2", new Date(), 6000, c2, 5.5);
        compteRepository.save(cp1);
        compteRepository.save(cp2);

        // Opérations sur cp1
        operationRepository.save(new Versement(new Date(), 9000, cp1));
        operationRepository.save(new Versement(new Date(), 6000, cp1));
        operationRepository.save(new Versement(new Date(), 2300, cp1));
        operationRepository.save(new Retrait(new Date(), 9000, cp1));

        // Opérations sur cp2
        operationRepository.save(new Versement(new Date(), 2300, cp2));
        operationRepository.save(new Versement(new Date(), 6000, cp2));
        operationRepository.save(new Versement(new Date(), 2300, cp2));
        operationRepository.save(new Retrait(new Date(), 9000, cp2));

        // Appel du service verser
        banqueMetier.verser("c1", 111111);
    }*/
}
