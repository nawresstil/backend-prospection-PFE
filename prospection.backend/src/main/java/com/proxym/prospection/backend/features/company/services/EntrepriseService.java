package com.proxym.prospection.backend.features.company.services;


import com.proxym.prospection.backend.features.company.dao.entities.Entreprise;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EntrepriseService {

    ResponseEntity<List<Entreprise>> getAllEntreprises();

    Entreprise createEntreprise(@RequestBody Entreprise entreprise);

    ResponseEntity<Entreprise> getEntrepriseById(@PathVariable Long id);
    ResponseEntity<Entreprise> getEntrepriseByName (@PathVariable String societyName);
//    Optional<EntrepriseDTO> findProspectById(Long id);

//    List<String> getAllBySocietyName();
    Entreprise modifier (@RequestBody Entreprise entrepriseDetails, @PathVariable Long id);

    ResponseEntity<Entreprise> deleteEntreprise(@PathVariable Long id);

    //for percentage
    List<Entreprise> findAllEnteprises();

}