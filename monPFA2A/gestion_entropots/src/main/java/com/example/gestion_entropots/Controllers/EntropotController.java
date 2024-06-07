package com.example.gestion_entropots.Controllers;

import com.example.gestion_entropots.Entities.Entropot;
import com.example.gestion_entropots.Services.EntropotService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping({"/gestion_entropots"})
public class EntropotController {
    @Autowired
    private EntropotService entropotservice;

    @GetMapping({"/entropots"})
    public List<Entropot> getentropot() {
        return entropotservice.listes_entropots();
    }

    @GetMapping({"/entropots/{id}"})
    public Entropot chercherentropot(@PathVariable long id) {
        return entropotservice.trouver_entropot(id);
    }

    @DeleteMapping({"/entropots/{id}"})
    public String supprimer_entropot(@PathVariable long id) {
        entropotservice.supprimer_entropot(id);
        return "entropot de numero " + id + "est supprimé";
    }

    @PostMapping({"/entropots"})
    public Entropot ajouter_entropot(@RequestBody Entropot e) {
        return entropotservice.creer_entropot(e);
    }

    @PutMapping({"/entropots"})
    public Entropot misajour_entropot(@RequestBody Entropot e) {
        return entropotservice.creer_entropot(e);
    }

    @DeleteMapping({"/entropots"})
    public String suprime() {
        entropotservice.supprime_tout();
        return "tout est supprimés";
    }
}

