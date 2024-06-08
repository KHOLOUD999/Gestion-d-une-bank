package com.example.mabank.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@DiscriminatorValue("V")
@Data
@NoArgsConstructor
public class Versement extends Operation {

    public Versement(Date dateOperation, double montant, Compte compte) {
        super(dateOperation, montant, compte);
    }
}
