package com.example.gestion_entropots.Controllers;

import com.example.gestion_entropots.Entities.Admin;
import com.example.gestion_entropots.Services.AdminService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor

@RequestMapping({"/gestion_entropots"})

public class AdminController {
    @Autowired
    private AdminService adminservice;

    @GetMapping({"/admins"})
    public List<Admin> getadmin() {
        return adminservice.listes_admins();
    }

    @GetMapping({"/admins/{id}"})
    public Admin chercheradmin(@PathVariable long id) {
        return adminservice.trouver_admin(id);
    }

    @DeleteMapping({"/admins/{id}"})
    public String supprimer_admin(@PathVariable long id) {
        adminservice.supprimer_admin(id);
        return "admin de numero " + id + "est supprimé";
    }

    @PostMapping({"/admins"})
    public Admin ajouter_admin(@RequestBody Admin e) {
        return adminservice.creer_admin(e);
    }

    @PutMapping({"/admins"})
    public Admin misajour_admin(@RequestBody Admin e) {
        return adminservice.creer_admin(e);
    }

    @DeleteMapping({"/admins"})
    public String suprime() {
        adminservice.supprime_tout();
        return "tout est supprimés";
    }
}

