package com.example.gestion_commande.Repo;

import com.example.gestion_commande.Entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Commanderepo extends JpaRepository<Commande,Long> {
    @Query("select a from Commande a where a.id_client.id = :id")
    List<Commande> findcommandeparclient(@Param("id") long id);
}
