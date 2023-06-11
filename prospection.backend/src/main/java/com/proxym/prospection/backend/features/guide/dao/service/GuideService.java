package com.proxym.prospection.backend.features.guide.dao.service;

import com.proxym.prospection.backend.features.company.dao.entities.Entreprise;
import com.proxym.prospection.backend.features.guide.dao.entities.GuideProspection;
import com.proxym.prospection.backend.features.project.dao.entities.Projet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface GuideService {


    GuideProspection createGuide(@RequestBody GuideProspection guideProspection);


    GuideProspection updateGuide(@RequestBody GuideProspection guideProspection, @PathVariable Long id);

    ResponseEntity<GuideProspection> deleteGuide(@PathVariable Long id);

    ResponseEntity<List<GuideProspection>> getAllGuide();
    ResponseEntity<GuideProspection> getGuideById(@PathVariable Long id);
}
