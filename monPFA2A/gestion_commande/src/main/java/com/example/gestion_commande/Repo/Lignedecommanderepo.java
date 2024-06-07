package com.example.gestion_commande.Repo;

import com.example.gestion_commande.Entities.Fournisseur;
import com.example.gestion_commande.Entities.Lignedecommande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Lignedecommanderepo extends JpaRepository<Lignedecommande,Long> {
}
