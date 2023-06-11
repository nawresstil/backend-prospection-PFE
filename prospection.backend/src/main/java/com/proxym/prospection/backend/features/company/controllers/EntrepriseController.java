package com.proxym.prospection.backend.features.company.controllers;

import com.proxym.prospection.backend.features.DTO.CountSocieties;
import com.proxym.prospection.backend.features.company.dao.entities.Entreprise;
import com.proxym.prospection.backend.features.company.services.EntrepriseService;
import com.proxym.prospection.backend.features.project.dao.entities.Projet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/entreprise")
@Slf4j
public class EntrepriseController {
    private final EntrepriseService entrepriseService;

    public EntrepriseController(EntrepriseService entrepriseService) {

        this.entrepriseService = entrepriseService;
    }
    @PostMapping("/create")
    public Entreprise createEntreprise(@RequestBody Entreprise entreprise) {
        return entrepriseService.createEntreprise(entreprise);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Entreprise>> getAllEntreprises() {

        return entrepriseService.getAllEntreprises();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Entreprise> getEntrepriseById(@PathVariable Long id) {

        return entrepriseService.getEntrepriseById(id);
    }
    @GetMapping("/name/{societyName}")
    public ResponseEntity<Entreprise> getEntrepriseByName(@PathVariable String societyName){
        return entrepriseService.getEntrepriseByName(societyName);
    }
    @GetMapping("/percentageCountStatus")
    List<CountSocieties> getPercentageGroupByStatus()
    {
        return entrepriseService.getPercentageGroupByStatus();
    }
    @GetMapping("/entreprises/projects/{entrepriseName}")
    public Iterable<Projet> getProjectsByEntrepriseName(@PathVariable String entrepriseName) {
        return entrepriseService.getProjectsByEntrepriseName(entrepriseName);
    }
  @PutMapping("/edit/{id}")
    public Entreprise updateEntreprise (@RequestBody Entreprise entrepriseDetails, @PathVariable Long id){
    return entrepriseService.modifier(entrepriseDetails,id);
}

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Entreprise> deleteEntreprise(@PathVariable Long id) {

        return entrepriseService.deleteEntreprise(id);
    }
}

