package com.example.gestion_entropots.Services;

import com.example.gestion_entropots.Entities.ProduitEntopot;
import com.example.gestion_entropots.Repo.ProduitEntropotrepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class ProduitEntopotService {
    private ProduitEntropotrepo produitentropotrepo;
    public ProduitEntopot creer_Produitentropot(ProduitEntopot e){
        return produitentropotrepo.save(e);
    }
    public void supprimer_Produitentropot(long id){
        ProduitEntopot e =trouver_Produitentropot(id);
        produitentropotrepo.delete(e);
    }
    public ProduitEntopot trouver_Produitentropot(long id){
        Optional<ProduitEntopot> et = produitentropotrepo.findById(id);
        return et.get();
    }
    public List<ProduitEntopot> Produitsofentropot(long id){
        return produitentropotrepo.findAllByidentropot(id);
    }
    public List<ProduitEntopot> listeparproduit(long id) {
        return produitentropotrepo.findbyproduit(id);
    }
    public List<ProduitEntopot> listes_Produitentropots(){
        return produitentropotrepo.findAll();
    }
    public void supprime_tout(){
        produitentropotrepo.findAll().forEach(e->produitentropotrepo.delete(e));
    }
}
