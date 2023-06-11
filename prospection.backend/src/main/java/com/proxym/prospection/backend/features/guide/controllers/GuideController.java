package com.proxym.prospection.backend.features.guide.controllers;

import com.proxym.prospection.backend.features.guide.dao.entities.GuideProspection;
import com.proxym.prospection.backend.features.guide.dao.service.GuideService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/guide")
@Slf4j
public class GuideController {
    private final GuideService guideService;
    public GuideController(GuideService guideService) {
        this.guideService = guideService;
    }

    @PostMapping("/create")
    public GuideProspection createGuide(@RequestBody GuideProspection guideProspection) {
        return guideService.createGuide(guideProspection);
    }
    @GetMapping("/all")
    public ResponseEntity<List<GuideProspection>> getAllGuide() {

        return guideService.getAllGuide();
    }
    @GetMapping("/{id}")
    public ResponseEntity<GuideProspection> getEntrepriseById(@PathVariable Long id) {

        return guideService.getGuideById(id);
    }
    @PutMapping("/edit/{id}")
    public GuideProspection updateGuide (@RequestBody GuideProspection guideProspection, @PathVariable Long id){
        return guideService.updateGuide(guideProspection,id);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GuideProspection> deleteGuide(@PathVariable Long id) {
        return guideService.deleteGuide(id);
    }
}
