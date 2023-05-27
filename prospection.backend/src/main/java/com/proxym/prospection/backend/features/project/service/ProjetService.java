package com.proxym.prospection.backend.features.project.service;

import com.proxym.prospection.backend.features.company.dao.entities.Entreprise;
import com.proxym.prospection.backend.features.project.dao.entities.Projet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProjetService {


    Projet createProjects(@RequestBody Projet projet);

    ResponseEntity<List<Projet>> getAllProjects();

    ResponseEntity<Projet> getProjectById(@PathVariable Long projetId);

//    ResponseEntity<Projet> updateProject(@PathVariable Long id, @RequestBody Projet projetDetails);
    Projet updateProject (@RequestBody Projet projetDetails, @PathVariable Long id);

    ResponseEntity<Projet> deleteProject(@PathVariable Long id);
}
