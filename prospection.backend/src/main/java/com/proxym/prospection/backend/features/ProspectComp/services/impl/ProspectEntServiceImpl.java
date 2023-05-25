package com.proxym.prospection.backend.features.ProspectComp.services.impl;

import com.proxym.prospection.backend.features.DTO.EntrepriseDTO;
import com.proxym.prospection.backend.features.ProspectComp.services.ProspectEntService;
import com.proxym.prospection.backend.features.company.dao.entities.Entreprise;
import com.proxym.prospection.backend.features.company.dao.repositories.EntrepriseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProspectEntServiceImpl implements ProspectEntService {

    @Autowired
    private final ModelMapper modelMapper;
    @Autowired

    private final EntrepriseRepository entrepriseRepository;


    public ProspectEntServiceImpl(ModelMapper modelMapper, EntrepriseRepository entrepriseRepository) {
        this.modelMapper = modelMapper;
        this.entrepriseRepository = entrepriseRepository;

    }

    @Override
    public ResponseEntity<List<EntrepriseDTO>> getProspect() {
        List<Entreprise> entreprises = entrepriseRepository.findProspect();
//          List<TacheS> tacheS = tacheSocRepository.findAll();
        List<EntrepriseDTO> clientDTO = entreprises.stream()
                .map(entreprise -> modelMapper.map(entreprise, EntrepriseDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(clientDTO);
    }

    @Override
    public ResponseEntity<EntrepriseDTO> deleteSociety(Long id) {
        Optional<Entreprise> entreprise = entrepriseRepository.findById(id);
        if (entreprise.isPresent()) {
            entrepriseRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else if (entreprise.isPresent()) {
            entrepriseRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}