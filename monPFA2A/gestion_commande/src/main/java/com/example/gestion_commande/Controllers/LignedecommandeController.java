package com.example.gestion_commande.Controllers;

import com.example.gestion_commande.Entities.Lignedecommande;
import com.example.gestion_commande.Services.LignedecommandeService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping({"/gestion_commandes"})

public class LignedecommandeController {
    @Autowired
    private LignedecommandeService lignedecommandeservice;

    @GetMapping({"/lignedecommandes"})
    public List<Lignedecommande> getlignedecommande() {
        return lignedecommandeservice.listes_lignedecommandes();
    }

    @GetMapping({"/lignedecommandes/{id}"})
    public Lignedecommande chercherlignedecommande(@PathVariable long id) {
        return lignedecommandeservice.trouver_lignedecommande(id);
    }

    @DeleteMapping({"/lignedecommandes/{id}"})
    public String supprimer_lignedecommande(@PathVariable long id) {
        lignedecommandeservice.supprimer_lignedecommande(id);
        return "lignedecommande de numero " + id + "est supprimé";
    }

    @PostMapping({"/lignedecommandes"})
    public Lignedecommande ajouter_lignedecommande(@RequestBody Lignedecommande e) {
        return lignedecommandeservice.creer_lignedecommande(e);
    }

    @PutMapping({"/lignedecommandes"})
    public Lignedecommande misajour_lignedecommande(@RequestBody Lignedecommande e) {
        return lignedecommandeservice.creer_lignedecommande(e);
    }

    @DeleteMapping({"/lignedecommandes"})
    public String suprime() {
        lignedecommandeservice.supprime_tout();
        return "tout est supprimés";
    }
}
