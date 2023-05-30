package com.proxym.prospection.backend.features.project.controllers;


import com.proxym.prospection.backend.features.company.dao.entities.Entreprise;
import com.proxym.prospection.backend.features.project.dao.entities.Projet;
import com.proxym.prospection.backend.features.project.service.ProjetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@Slf4j
public class ProjectController {


    private final ProjetService projetService;

    public ProjectController(ProjetService projetService) {
        this.projetService = projetService;
    }

    @PostMapping("/add")
    public Projet createProjects(@RequestBody Projet projet) {

        return projetService.createProjects(projet, projet.getSocietName());
    }


    @GetMapping("/all")
    public ResponseEntity<List<Projet>> getAllProjects() {

        return projetService.getAllProjects();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Projet> getProjectById(@PathVariable Long id) {

        return projetService.getProjectById(id);
    }

    @PutMapping("/update/{id}")
    public Projet  updateProject( @RequestBody Projet projetDetails,@PathVariable Long id) {

        return projetService.updateProject(projetDetails,id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Projet> deleteProject(@PathVariable Long id) {

        return projetService.deleteProject(id);
    }
 }
