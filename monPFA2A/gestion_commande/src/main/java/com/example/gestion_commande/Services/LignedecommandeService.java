package com.example.gestion_commande.Services;

import com.example.gestion_commande.Entities.Lignedecommande;
import com.example.gestion_commande.Repo.Lignedecommanderepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class LignedecommandeService {
    private Lignedecommanderepo lignedecommanderepo;
    public Lignedecommande creer_lignedecommande(Lignedecommande e){
        return lignedecommanderepo.save(e);
    }
    public void supprimer_lignedecommande(long id){
        Lignedecommande e =trouver_lignedecommande(id);
        lignedecommanderepo.delete(e);
    }
    public Lignedecommande trouver_lignedecommande(long id){
        Optional<Lignedecommande> et = lignedecommanderepo.findById(id);
        return et.get();
    }
    public List<Lignedecommande> listes_lignedecommandes(){
        return lignedecommanderepo.findAll();
    }
    public void supprime_tout(){
        lignedecommanderepo.findAll().forEach(e->lignedecommanderepo.delete(e));
    }
}
