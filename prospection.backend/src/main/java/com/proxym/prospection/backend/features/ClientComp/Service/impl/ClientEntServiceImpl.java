package com.proxym.prospection.backend.features.ClientComp.Service.impl;

import com.proxym.prospection.backend.features.ClientComp.Service.ClientEntService;
import com.proxym.prospection.backend.features.DTO.EntrepriseDTO;
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
public class ClientEntServiceImpl implements ClientEntService {

        @Autowired
        private final ModelMapper modelMapper;
        @Autowired

        private final EntrepriseRepository entrepriseRepository;


        public ClientEntServiceImpl(ModelMapper modelMapper, EntrepriseRepository entrepriseRepository) {
            this.modelMapper = modelMapper;
            this.entrepriseRepository = entrepriseRepository;

        }

        @Override
        public ResponseEntity<List<EntrepriseDTO>> getClient() {
            List<Entreprise> entreprises = entrepriseRepository.findClient();
//        List<TacheS> tacheS = tacheSocRepository.findAll();
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
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        @Override
        public ResponseEntity<EntrepriseDTO> getClientById(Long id) {
            Optional<Entreprise> entreprise = entrepriseRepository.findById(id);

            if (entreprise.isEmpty()) {
                return ResponseEntity.notFound().build();
            }else {
                EntrepriseDTO entrepriseDTO = convertToDTO(entreprise.get());
                return ResponseEntity.ok().body(entrepriseDTO);
            }
        }

        private EntrepriseDTO convertToDTO(Entreprise entreprise) {
            EntrepriseDTO entrepriseDTO = new EntrepriseDTO();

            entrepriseDTO.setId(entreprise.getId());
            entrepriseDTO.setSocietyName(entreprise.getSocietyName());
//      entrepriseDTO.setCreationDate((Date) entreprise.getCreationDate());
            entrepriseDTO.setFunction(entreprise.getFunction());
            return entrepriseDTO;
        }

    }
