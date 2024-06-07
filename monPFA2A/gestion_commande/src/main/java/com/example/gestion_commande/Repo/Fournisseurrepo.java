package com.example.gestion_commande.Repo;

import com.example.gestion_commande.Entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Fournisseurrepo extends JpaRepository<Fournisseur,Long> {
}
