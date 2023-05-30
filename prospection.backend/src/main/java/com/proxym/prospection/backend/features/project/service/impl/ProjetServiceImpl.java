package com.proxym.prospection.backend.features.project.service.impl;

import com.proxym.prospection.backend.features.company.dao.entities.Entreprise;
import com.proxym.prospection.backend.features.company.dao.repositories.EntrepriseRepository;
import com.proxym.prospection.backend.features.project.dao.entities.Projet;
import com.proxym.prospection.backend.features.project.dao.repositories.ProjectRepository;
import com.proxym.prospection.backend.features.project.service.ProjetService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProjetServiceImpl implements ProjetService {

    private final ProjectRepository projectRepository;
    private final EntrepriseRepository entrepriseRepository;

    public ProjetServiceImpl(ProjectRepository projectRepository, EntrepriseRepository entrepriseRepository) {
        this.projectRepository = projectRepository;
        this.entrepriseRepository = entrepriseRepository;
    }

    @Override
    public Projet createProjects(@RequestBody Projet projet, String societyName) {
        Entreprise society = entrepriseRepository.findSocietyBySocietyName(societyName);
        projet.setEntreprise(society); // to add id-entreprise
        return projectRepository.save(projet);
    }

    @Override
    public ResponseEntity<List<Projet>> getAllProjects() {
        List<Projet> projet = projectRepository.findAll();


        return ResponseEntity.ok().body(projet);
    }

    @Override
    public ResponseEntity<Projet> getProjectById(@PathVariable Long projetId) {
        Projet projet = projectRepository.findById(projetId).orElse(null);

        if (projet == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(projet);
    }

    @Override
    public Projet updateProject(Projet projetDetails, Long id, String societyName) {
        projetDetails.setId(id);
        Entreprise society = entrepriseRepository.findSocietyBySocietyName(societyName);
        projetDetails.setEntreprise(society);
        return projectRepository.saveAndFlush(projetDetails);
    }

    @Override
    public ResponseEntity<Projet> deleteProject(@PathVariable Long id) {
        Projet projet = projectRepository.findById(id).orElse(null);

        if (projet == null) {
            return ResponseEntity.notFound().build();
        }

        projectRepository.delete(projet);

        return ResponseEntity.ok().build();
    }
}
