package com.example.gestion_entropots.Entities;

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
public class Entropot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String adresse;
    @ManyToOne
    private Stock stock;
    @ManyToOne
    private Admin admin;
    @JsonIgnore
    @OneToMany(mappedBy = "entropot")
    private List<ProduitEntopot> produitEntopots;
}
