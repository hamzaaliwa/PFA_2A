package com.example.gestion_commande.Controllers;

import com.example.gestion_commande.Entities.Produit;
import com.example.gestion_commande.Services.ProduitService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping({"/gestion_commandes"})
public class ProduitController {
    @Autowired
    private ProduitService produitservice;

    @GetMapping({"/produits"})
    public List<Produit> getproduit() {
        return produitservice.listes_produits();
    }

    @GetMapping({"/produits/{id}"})
    public Produit chercherproduit(@PathVariable long id) {
        return produitservice.trouver_produit(id);
    }

    @DeleteMapping({"/produits/{id}"})
    public String supprimer_produit(@PathVariable long id) {
        produitservice.supprimer_produit(id);
        return "produit de numero " + id + "est supprimé";
    }

    @PostMapping({"/produits"})
    public Produit ajouter_produit(@RequestBody Produit e) {
        return produitservice.creer_produit(e);
    }

    @PutMapping({"/produits"})
    public Produit misajour_produit(@RequestBody Produit e) {
        return produitservice.creer_produit(e);
    }

    @DeleteMapping({"/produits"})
    public String suprime() {
        produitservice.supprime_tout();
        return "tout est supprimés";
    }
}

