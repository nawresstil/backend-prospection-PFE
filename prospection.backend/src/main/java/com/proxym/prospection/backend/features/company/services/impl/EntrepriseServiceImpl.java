package com.proxym.prospection.backend.features.company.services.impl;

import com.proxym.prospection.backend.features.company.dao.entities.Entreprise;
import com.proxym.prospection.backend.features.company.dao.repositories.EntrepriseRepository;
import com.proxym.prospection.backend.features.company.services.EntrepriseService;
import com.proxym.prospection.backend.features.task.dao.entities.TacheS;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashSet;
import java.util.List;

@Service
public class EntrepriseServiceImpl implements EntrepriseService {
    private final EntrepriseRepository entrepriseRepository;

    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository) {

        this.entrepriseRepository = entrepriseRepository;
    }

    @Override
    public ResponseEntity<List<Entreprise>> getAllEntreprises() {

        List<Entreprise> entreprise = entrepriseRepository.findAll();


        return ResponseEntity.ok().body(entreprise);
    }

    @Override
    public Entreprise createEntreprise(@RequestBody Entreprise entreprise) {
//        entreprise.setTacheS(new HashSet<TacheS>() {}); //when create entreprise add id tacheS
    return entrepriseRepository.save(entreprise);
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
    public List<Entreprise> findAllEnteprises() {
        return entrepriseRepository.findAll();
    }

}
