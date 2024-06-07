package com.example.gestion_commande.Controllers;

import com.example.gestion_commande.Entities.Fournisseur;
import com.example.gestion_commande.Services.Fournisseurservice;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping({"/gestion_commandes"})

public class FournisseurController {
    @Autowired
    private Fournisseurservice fournisseurservice;

    @GetMapping({"/fournisseurs"})
    public List<Fournisseur> getfournisseur() {
        return fournisseurservice.listes_fournisseurs();
    }

    @GetMapping({"/fournisseurs/{id}"})
    public Fournisseur chercherfournisseur(@PathVariable long id) {
        return fournisseurservice.trouver_fournisseur(id);
    }

    @DeleteMapping({"/fournisseurs/{id}"})
    public String supprimer_fournisseur(@PathVariable long id) {
        fournisseurservice.supprimer_fournisseur(id);
        return "fournisseur de numero " + id + "est supprimé";
    }

    @PostMapping({"/fournisseurs"})
    public Fournisseur ajouter_fournisseur(@RequestBody Fournisseur e) {
        return fournisseurservice.creer_fournisseur(e);
    }

    @PutMapping({"/fournisseurs"})
    public Fournisseur misajour_fournisseur(@RequestBody Fournisseur e) {
        return fournisseurservice.creer_fournisseur(e);
    }

    @DeleteMapping({"/fournisseurs"})
    public String suprime() {
        fournisseurservice.supprime_tout();
        return "tout est supprimés";
    }
}
