package com.example.gestion_entropots.Repo;

import com.example.gestion_entropots.Entities.ProduitEntopot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitEntropotrepo extends JpaRepository<ProduitEntopot,Long> {
    @Query("select a from ProduitEntopot a where a.entropot.id = :id")
    List<ProduitEntopot> findAllByidentropot(@Param("id") long id);


    @Query("select a from ProduitEntopot a where a.produit.id = :id")
    List<ProduitEntopot> findbyproduit(@Param("id") long id);
}
