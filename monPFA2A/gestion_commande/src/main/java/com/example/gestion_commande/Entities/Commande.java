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
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Produit> produits;
    @OneToOne
    private Client id_client;
    @JsonIgnore
    @OneToMany(mappedBy = "commande")
    private List<Lignedecommande> lignedecommandes;
}

