//package com.proxym.prospection.backend.features.guide.controllers;
//
//import com.proxym.prospection.backend.features.company.dao.entities.Entreprise;
//import com.proxym.prospection.backend.features.company.services.EntrepriseService;
//import com.proxym.prospection.backend.features.guide.dao.entities.GuideProspection;
//import com.proxym.prospection.backend.features.guide.dao.service.GuideService;
//import com.proxym.prospection.backend.features.project.dao.entities.Projet;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping( "/guide")
//@Slf4j
//public class GuideController {
//    private final GuideService guideService;
//
//
//    public GuideController(GuideService guideService) {
//        this.guideService = guideService;
//    }
//
//    @PostMapping("/create")
//    public GuideProspection createEntreprise(@RequestBody GuideProspection guideProspection) {
//        return guideService.createGuide(guideProspection);
//    }
//    @GetMapping("/all")
//    public ResponseEntity<List<GuideProspection>> getAllGuide() {
//
//        return guideService.getAllGuide();
//    }
//    @GetMapping("/{id}")
//    public ResponseEntity<Entreprise> getEntrepriseById(@PathVariable Long id) {
//
//        return entrepriseService.getEntrepriseById(id);
//    }
//    @GetMapping("/name/{societyName}")
//    public ResponseEntity<Entreprise> getEntrepriseByName(@PathVariable String societyName){
//        return entrepriseService.getEntrepriseByName(societyName);
//    }
//    @GetMapping("/entreprises/projects/{entrepriseName}")
//    public Iterable<Projet> getProjectsByEntrepriseName(@PathVariable String entrepriseName) {
//        return entrepriseService.getProjectsByEntrepriseName(entrepriseName);
//    }
//    @PutMapping("/edit/{id}")
//    public Entreprise updateEntreprise (@RequestBody Entreprise entrepriseDetails, @PathVariable Long id){
//        return entrepriseService.modifier(entrepriseDetails,id);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Entreprise> deleteEntreprise(@PathVariable Long id) {
//
//        return entrepriseService.deleteEntreprise(id);
//    }
//}
