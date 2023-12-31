package com.proxym.prospection.backend.features.company.services;


import com.proxym.prospection.backend.features.DTO.CountSocieties;
import com.proxym.prospection.backend.features.company.dao.entities.Entreprise;
import com.proxym.prospection.backend.features.project.dao.entities.Projet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EntrepriseService {

    ResponseEntity<List<Entreprise>> getAllEntreprises();

    Entreprise createEntreprise(@RequestBody Entreprise entreprise);

    Iterable<Projet> getProjectsByEntrepriseName(String entrepriseName);

    ResponseEntity<Entreprise> getEntrepriseById(@PathVariable Long id);
    ResponseEntity<Entreprise> getEntrepriseByName (@PathVariable String societyName);
    List<CountSocieties> getPercentageGroupByStatus();
    Entreprise modifier (@RequestBody Entreprise entrepriseDetails, @PathVariable Long id);

    ResponseEntity<Entreprise> deleteEntreprise(@PathVariable Long id);

}