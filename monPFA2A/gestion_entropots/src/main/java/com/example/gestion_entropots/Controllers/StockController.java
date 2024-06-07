package com.example.gestion_entropots.Controllers;

import com.example.gestion_entropots.Entities.Stock;
import com.example.gestion_entropots.Services.StockService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping({"/gestion_entropots"})

public class StockController {
    @Autowired
    private StockService stockservice;

    @GetMapping({"/stocks"})
    public List<Stock> getstock() {
        return stockservice.listes_stocks();
    }

    @GetMapping({"/stocks/{id}"})
    public Stock chercherstock(@PathVariable long id) {
        return stockservice.trouver_stock(id);
    }

    @DeleteMapping({"/stocks/{id}"})
    public String supprimer_stock(@PathVariable long id) {
        stockservice.supprimer_stock(id);
        return "stock de numero " + id + "est supprimé";
    }

    @PostMapping({"/stocks"})
    public Stock ajouter_stock(@RequestBody Stock e) {
        return stockservice.creer_stock(e);
    }

    @PutMapping({"/stocks"})
    public Stock misajour_stock(@RequestBody Stock e) {
        return stockservice.creer_stock(e);
    }

    @DeleteMapping({"/stocks"})
    public String suprime() {
        stockservice.supprime_tout();
        return "tout est supprimés";
    }
}

