package com.example.mabank.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
@Data
@NoArgsConstructor
public abstract class Operation {
    @Id @GeneratedValue
    private Long numero;
    private Date dateOperation;
    private double montant;
    @ManyToOne
    @JoinColumn(name = "CODE_CPTE")
    private Compte compte;

    public Operation(Date dateOperation, double montant, Compte compte) {
        this.dateOperation = dateOperation;
        this.montant = montant;
        this.compte = compte;
    }
}
