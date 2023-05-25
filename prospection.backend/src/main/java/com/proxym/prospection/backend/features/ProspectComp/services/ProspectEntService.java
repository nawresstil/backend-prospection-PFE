package com.proxym.prospection.backend.features.ProspectComp.services;

import com.proxym.prospection.backend.features.DTO.EntrepriseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProspectEntService {
    ResponseEntity<List<EntrepriseDTO>> getProspect();

    ResponseEntity<EntrepriseDTO> deleteSociety(@PathVariable Long id);
}
