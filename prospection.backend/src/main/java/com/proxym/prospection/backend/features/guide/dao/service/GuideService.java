//package com.proxym.prospection.backend.features.guide.dao.service;
//
//import com.proxym.prospection.backend.features.guide.dao.entities.GuideProspection;
//import com.proxym.prospection.backend.features.project.dao.entities.Projet;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.List;
//
//public interface GuideService {
//
//
//    GuideProspection createGuide(@RequestBody GuideProspection guideProspection);
//
//    ResponseEntity<Projet> getProjectById(@PathVariable Long projetId);
//
//    GuideProspection updateGuide(GuideProspection guideProspection, Long id);
//
//    ResponseEntity<GuideProspection> deleteGuide(@PathVariable Long id);
//
//    ResponseEntity<List<GuideProspection>> getAllGuide();
//}
