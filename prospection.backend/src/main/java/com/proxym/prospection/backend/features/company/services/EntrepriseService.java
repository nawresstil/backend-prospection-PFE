package com.proxym.prospection.backend.features.company.services;


import com.proxym.prospection.backend.features.company.dao.entities.Entreprise;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EntrepriseService {

    ResponseEntity<List<Entreprise>> getAllEntreprises();

    Entreprise createEntreprise(@RequestBody Entreprise entreprise);

//  Entreprise createEntreprise(@RequestBody Entreprise entreprise,@RequestParam("image") MultipartFile file);


    ResponseEntity<Entreprise> getEntrepriseById(@PathVariable Long id);
    ResponseEntity<Entreprise> getEntrepriseByName (@PathVariable String societyName);
//    Optional<EntrepriseDTO> findProspectById(Long id);

//    List<String> getAllBySocietyName();

    ResponseEntity<Entreprise> updateEntreprise(@PathVariable Long Id, @RequestBody Entreprise entrepriseDetails);

    ResponseEntity<Entreprise> deleteEntreprise(@PathVariable Long id);

    List<Entreprise> findAllEnteprises();


    List<Entreprise> findEntreprisesWithSorting(@PathVariable String field);

    Page<Entreprise> findEntreprisesWithPagination(int offset, int pageSize);

    Page<Entreprise> findEntreprisesWithPaginationAndSorting(int offset, int pageSize, String field);
}