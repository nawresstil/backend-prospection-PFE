package com.proxym.prospection.backend.features.ProspectComp.controllers;

import com.proxym.prospection.backend.features.DTO.EntrepriseDTO;
import com.proxym.prospection.backend.features.ProspectComp.services.ProspectEntService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
    @RequestMapping( "/prospects")
    @Slf4j

    public class ProspectEntController {

        @Autowired
        private final ProspectEntService prospectEntService;

        public ProspectEntController(ProspectEntService prospectEntService) {

            this.prospectEntService = prospectEntService;
        }

        @GetMapping("/all")
        public ResponseEntity<List<EntrepriseDTO>> getProspect() {
            return prospectEntService.getProspect();
        }


        @DeleteMapping("/delete/{id}")
        public ResponseEntity<EntrepriseDTO> deleteEntreprise(@PathVariable Long id) {
            return prospectEntService.deleteSociety(id);
        }
    }
