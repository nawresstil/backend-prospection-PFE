package com.proxym.prospection.backend.features.company.services.impl;

import com.proxym.prospection.backend.features.DTO.CountSocieties;
import com.proxym.prospection.backend.features.company.dao.entities.Entreprise;
import com.proxym.prospection.backend.features.company.dao.repositories.EntrepriseRepository;
import com.proxym.prospection.backend.features.company.services.EntrepriseService;
import com.proxym.prospection.backend.features.project.dao.entities.Projet;
import com.proxym.prospection.backend.features.project.dao.repositories.ProjectRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EntrepriseServiceImpl implements EntrepriseService {
    private final EntrepriseRepository entrepriseRepository;
    private final ProjectRepository projetRepository;

    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository, ProjectRepository projetRepository) {

        this.entrepriseRepository = entrepriseRepository;
        this.projetRepository = projetRepository;
    }

    @Override
    public ResponseEntity<List<Entreprise>> getAllEntreprises() {

        List<Entreprise> entreprise = entrepriseRepository.findAll();


        return ResponseEntity.ok().body(entreprise);
    }

    @Override
    public Entreprise createEntreprise(@RequestBody Entreprise entreprise) {
    return entrepriseRepository.save(entreprise);
    }



    @Override
    public Iterable<Projet> getProjectsByEntrepriseName(String entrepriseName) {
        Entreprise entreprise = entrepriseRepository.findSocietyBySocietyName(entrepriseName);
        if (entreprise != null) {
            return projetRepository.findByEntreprise(entreprise);
        } else {
            return null;
        }
    }
    @Override
    public ResponseEntity<Entreprise> getEntrepriseById(@PathVariable Long id) {
        Entreprise entreprise = entrepriseRepository.findById(id).orElse(null);

        if (entreprise == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(entreprise);
    }
    @Override
    public ResponseEntity<Entreprise> getEntrepriseByName(@PathVariable String societyName) {
        Entreprise entreprise = entrepriseRepository.findSocietyBySocietyName(societyName);

        if (entreprise == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(entreprise);
    }
    @Override
    public Entreprise modifier(Entreprise entrepriseDetails, Long id) {
        entrepriseDetails.setId(id);
        return entrepriseRepository.saveAndFlush(entrepriseDetails);
    }

    @Override

    public ResponseEntity<Entreprise> deleteEntreprise(@PathVariable Long id) {
        Entreprise entreprise = entrepriseRepository.findById(id).orElse(null);

        if (entreprise == null) {
            return ResponseEntity.notFound().build();
        }
        entrepriseRepository.delete(entreprise);
        return ResponseEntity.ok().build();
    }

    @Override
    public List<CountSocieties> getPercentageGroupByStatus(){
        return entrepriseRepository.getPercentageGroupByStatus();
    }

}
