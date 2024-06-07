package com.example.gestion_commande.Controllers;

import com.example.gestion_commande.Entities.Commande;
import com.example.gestion_commande.Services.CommandeService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping({"/gestion_commandes"})

public class CommandeController {
    @Autowired
    private CommandeService commandeservice;

    @GetMapping({"/commandes"})
    public List<Commande> getcommande() {
        return commandeservice.listes_commandes();
    }

    @GetMapping({"/commandes/commandeparclient/{id}"})
    public List<Commande> getcommandesparclient(@PathVariable long id) {
        return commandeservice.listesparclient(id);
    }

    @GetMapping({"/commandes/{id}"})
    public Commande cherchercommande(@PathVariable long id) {
        return commandeservice.trouver_commande(id);
    }

    @DeleteMapping({"/commandes/{id}"})
    public String supprimer_commande(@PathVariable long id) {
        commandeservice.supprimer_commande(id);
        return "commande de numero " + id + "est supprimé";
    }

    @PostMapping({"/commandes"})
    public Commande ajouter_commande(@RequestBody Commande e) {
        return commandeservice.creer_commande(e);
    }

    @PutMapping({"/commandes"})
    public Commande misajour_commande(@RequestBody Commande e) {
        return commandeservice.creer_commande(e);
    }

    @DeleteMapping({"/commandes"})
    public String suprime() {
        commandeservice.supprime_tout();
        return "tout est supprimés";
    }
}

