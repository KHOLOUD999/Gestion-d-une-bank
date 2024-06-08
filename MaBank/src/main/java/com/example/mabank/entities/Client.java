package com.example.mabank.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    private String nom;
    private String email;
    @OneToMany(mappedBy ="client", fetch = FetchType.LAZY)
    private Collection<Compte> comptes;

    public Client(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }

}
