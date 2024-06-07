package com.example.gestion_entropots.Repo;

import com.example.gestion_entropots.Entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Stockrepo extends JpaRepository<Stock,Long> {
}
