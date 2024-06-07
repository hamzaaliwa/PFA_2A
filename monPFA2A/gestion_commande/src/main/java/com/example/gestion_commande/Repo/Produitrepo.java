package com.example.gestion_commande.Repo;

import com.example.gestion_commande.Entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produitrepo extends JpaRepository<Produit,Long> {
}
