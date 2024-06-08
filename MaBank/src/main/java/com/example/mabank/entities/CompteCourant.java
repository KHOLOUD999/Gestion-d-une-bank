package com.example.mabank.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@DiscriminatorValue("CC")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompteCourant extends Compte {
    private double decouvert;

    public CompteCourant(String codeCompte, Date dateCreation, double solde, Client client, double decouvert) {
        super(codeCompte, dateCreation, solde, client);
        this.decouvert = decouvert;
    }
}
