package com.example.gestion_entropots.Repo;

import com.example.gestion_entropots.Entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produitrepo extends JpaRepository<Produit,Long> {
}
