package com.example.mabank.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@DiscriminatorValue("CE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompteEpargne extends Compte {
    private double taux;

    public CompteEpargne(String codeCompte, Date dateCreation, double solde, Client client, double taux) {
        super(codeCompte, dateCreation, solde, client);
        this.taux = taux;
    }
}
