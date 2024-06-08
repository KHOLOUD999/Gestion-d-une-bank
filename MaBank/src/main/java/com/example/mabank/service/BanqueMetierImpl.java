package com.example.mabank.service;

import com.example.mabank.dao.CompteRepository;
import com.example.mabank.dao.OperationRepository;
import com.example.mabank.entities.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@Transactional
public class BanqueMetierImpl implements IBanqueMetier {
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private OperationRepository operationRepository;

    @Override
    public Compte consulterCompte(String codeCpte) {
        Optional<Compte> cp = compteRepository.findById(codeCpte);
        if (!cp.isPresent()) throw new RuntimeException("Compte introuvable");
        return cp.get();
    }

    @Override
    public void verser(String codeCpte, double montant) {
        Compte cp = consulterCompte(codeCpte);
        Versement v = new Versement(new Date(), montant, cp);
        operationRepository.save(v);
        cp.setSolde(cp.getSolde() + montant);
        compteRepository.save(cp);
    }

    @Override
    public void retirer(String codeCpte, double montant) {
        Compte cp = consulterCompte(codeCpte);
        double facilitesCaisee = 0;
        if (cp instanceof CompteCourant)
            facilitesCaisee = ((CompteCourant) cp).getDecouvert();
        if (cp.getSolde() + facilitesCaisee < montant)
            throw new RuntimeException("Solde insuffisant");
        Retrait r = new Retrait(new Date(), montant, cp);
        operationRepository.save(r);
        cp.setSolde(cp.getSolde() - montant);
        compteRepository.save(cp);
    }


    @Override
    public void virement(String codeCpte1, String codeCpte2, double montant) {
        if(codeCpte1.equals(codeCpte2))
            throw new RuntimeException("Impossible d'effectuer un virement sur le meme compte!");
        retirer(codeCpte1, montant);
        verser(codeCpte2, montant);
    }

    @Override
    public Page<Operation> listOperation(String codeCpte, int page, int size) {
        return operationRepository.listOperation(codeCpte, PageRequest.of(page, size));
    }
}
