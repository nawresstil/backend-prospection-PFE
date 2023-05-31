//package com.proxym.prospection.backend.features.guide.dao.service.impl;
//
//
//import com.proxym.prospection.backend.features.guide.dao.entities.GuideProspection;
//import com.proxym.prospection.backend.features.guide.dao.repositories.GuideRepository;
//import com.proxym.prospection.backend.features.guide.dao.service.GuideService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//
//@Service
//public class GuideServiceImpl implements GuideService {
//
//    private final GuideRepository guideRepository;
//
//    public GuideServiceImpl(GuideRepository guideRepository) {
//        this.guideRepository = guideRepository;
//    }
//
//    @Override
//    public GuideProspection createGuide(@RequestBody GuideProspection guideProspection) {
//        return guideRepository.save(guideProspection);
//    }
//
//
//
//
//    @Override
//    public GuideProspection updateGuide(GuideProspection guideProspection, Long id) {
//        guideProspection.setId(id);
//        return guideRepository.saveAndFlush(guideProspection);
//    }
//
//    @Override
//    public ResponseEntity<GuideProspection> deleteGuide(@PathVariable Long id) {
//        GuideProspection guide = guideRepository.findById(id).orElse(null);
//
//        if (guide == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        guideRepository.delete(guide);
//
//        return ResponseEntity.ok().build();
//    }
//}
