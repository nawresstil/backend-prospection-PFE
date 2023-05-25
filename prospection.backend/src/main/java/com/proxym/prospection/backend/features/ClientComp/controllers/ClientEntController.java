package com.proxym.prospection.backend.features.ClientComp.controllers;

import com.proxym.prospection.backend.features.ClientComp.Service.ClientEntService;
import com.proxym.prospection.backend.features.DTO.EntrepriseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping( "/clients")
    @Slf4j

    public class ClientEntController {

        @Autowired
        private final ClientEntService clientEntService;

        public ClientEntController(ClientEntService clientEntService) {

            this.clientEntService = clientEntService;
        }

        @GetMapping("/all")
        public ResponseEntity<List<EntrepriseDTO>> getClient() {
            return clientEntService.getClient();
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<EntrepriseDTO> deleteEntreprise(@PathVariable Long id) {
            return clientEntService.deleteSociety(id);
        }

        @GetMapping("/{id}")
        public ResponseEntity<EntrepriseDTO> getClientById(@PathVariable Long id) {
            return clientEntService.getClientById(id);
        }
}
