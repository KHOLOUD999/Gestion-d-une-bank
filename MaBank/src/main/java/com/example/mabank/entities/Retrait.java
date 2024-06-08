package com.example.mabank.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@DiscriminatorValue("R")
@Data
@NoArgsConstructor
public class Retrait extends Operation {

    public Retrait(Date dateOperation, double montant, Compte compte) {
        super(dateOperation, montant, compte);
    }
}
