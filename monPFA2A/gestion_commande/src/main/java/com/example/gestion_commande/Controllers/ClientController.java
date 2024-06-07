package com.example.gestion_commande.Controllers;

import com.example.gestion_commande.Entities.Client;
import com.example.gestion_commande.Services.ClientService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping({"/gestion_commandes"})
public class ClientController {
    @Autowired
    private ClientService clientservice;

    @GetMapping({"/clients"})
    public List<Client> getclient() {
        return clientservice.listes_clients();
    }

    @GetMapping({"/clients/{id}"})
    public Client chercherclient(@PathVariable long id) {
        return clientservice.trouver_client(id);
    }

    @DeleteMapping({"/clients/{id}"})
    public String supprimer_client(@PathVariable long id) {
        clientservice.supprimer_client(id);
        return "client de numero " + id + "est supprimé";
    }

    @PostMapping({"/clients"})
    public Client ajouter_client(@RequestBody Client e) {
        return clientservice.creer_client(e);
    }

    @PutMapping({"/clients"})
    public Client misajour_client(@RequestBody Client e) {
        return clientservice.creer_client(e);
    }

    @DeleteMapping({"/clients"})
    public String suprime() {
        clientservice.supprime_tout();
        return "tout est supprimés";
    }
}

