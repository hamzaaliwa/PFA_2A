package com.example.gestion_commande.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String etat_physique;
    @ManyToOne
    private Fournisseur fournisseur;
    @JsonIgnore
    @ManyToMany(mappedBy = "produits" , fetch = FetchType.EAGER)
    private List<Commande> commandes;
    @JsonIgnore
    @OneToMany(mappedBy = "produit")
    private List<Lignedecommande> lignedecommandes;
}
