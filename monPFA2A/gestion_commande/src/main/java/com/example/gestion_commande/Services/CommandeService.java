package com.example.gestion_commande.Services;

import com.example.gestion_commande.Entities.Commande;
import com.example.gestion_commande.Repo.Commanderepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class CommandeService {
    private Commanderepo commanderepo;
    public Commande creer_commande(Commande e){
        return commanderepo.save(e);
    }
    public void supprimer_commande(long id){
        Commande e =trouver_commande(id);
        commanderepo.delete(e);
    }
    public Commande trouver_commande(long id){
        Optional<Commande> et = commanderepo.findById(id);
        return et.get();
    }
    public List<Commande> listesparclient(long id){
        return commanderepo.findcommandeparclient(id);
    }
    public List<Commande> listes_commandes(){
        return commanderepo.findAll();
    }
    public void supprime_tout(){
        commanderepo.findAll().forEach(e->commanderepo.delete(e));
    }
}
