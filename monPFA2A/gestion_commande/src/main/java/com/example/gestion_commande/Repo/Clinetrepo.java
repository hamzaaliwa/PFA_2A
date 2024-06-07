package com.example.gestion_commande.Repo;


import com.example.gestion_commande.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Clinetrepo extends JpaRepository<Client,Long> {
}
