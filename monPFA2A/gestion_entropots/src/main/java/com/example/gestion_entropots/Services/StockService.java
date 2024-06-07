package com.example.gestion_entropots.Services;

import com.example.gestion_entropots.Entities.Stock;
import com.example.gestion_entropots.Repo.Stockrepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class StockService {
    private Stockrepo stockrepo;
    public Stock creer_stock(Stock e){
        return stockrepo.save(e);
    }
    public void supprimer_stock(long id){
        Stock e =trouver_stock(id);
        stockrepo.delete(e);
    }
    public Stock trouver_stock(long id){
        Optional<Stock> et = stockrepo.findById(id);
        return et.get();
    }
    public List<Stock> listes_stocks(){
        return stockrepo.findAll();
    }
    public void supprime_tout(){
        stockrepo.findAll().forEach(e->stockrepo.delete(e));
    }
}
