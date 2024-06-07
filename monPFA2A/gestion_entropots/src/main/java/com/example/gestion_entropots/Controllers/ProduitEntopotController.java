package com.example.gestion_entropots.Controllers;

import com.example.gestion_entropots.Entities.ProduitEntopot;
import com.example.gestion_entropots.Services.ProduitEntopotService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping({"/gestion_entropots"})

public class ProduitEntopotController {
    @Autowired
    private ProduitEntopotService produitentropot;

    @GetMapping({"/Produitentropots"})
    public List<ProduitEntopot> getProduitentropot() {
        return produitentropot.listes_Produitentropots();
    }

    @GetMapping({"/Produitentropots/{id}"})
    public ProduitEntopot chercherProduitentropot(@PathVariable long id) {
        return produitentropot.trouver_Produitentropot(id);
    }
    @GetMapping({"/Produitentropots/prdosuitsbyentropots/{id}"})
    public List<ProduitEntopot> produitsofentropot(@PathVariable long id){
        return produitentropot.Produitsofentropot(id);
    }
    @GetMapping({"/Produitentropots/toutparidproduit/{id}"})
    public List<ProduitEntopot> listparprod(@PathVariable long id){
        return produitentropot.listeparproduit(id);
    }
    @DeleteMapping({"/Produitentropots/{id}"})
    public String supprimer_Produitentropot(@PathVariable long id) {
        produitentropot.supprimer_Produitentropot(id);
        return "Produitentropot de numero " + id + "est supprimé";
    }

    @PostMapping({"/Produitentropots"})
    public ProduitEntopot ajouter_Produitentropot(@RequestBody ProduitEntopot e) {
        return produitentropot.creer_Produitentropot(e);
    }

    @PutMapping({"/Produitentropots"})
    public ProduitEntopot misajour_Produitentropot(@RequestBody ProduitEntopot e) {
        return produitentropot.creer_Produitentropot(e);
    }

    @DeleteMapping({"/Produitentropots"})
    public String suprime() {
        produitentropot.supprime_tout();
        return "tout est supprimés";
    }
}
