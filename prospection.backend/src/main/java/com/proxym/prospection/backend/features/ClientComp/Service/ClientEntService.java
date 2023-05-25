package com.proxym.prospection.backend.features.ClientComp.Service;

import com.proxym.prospection.backend.features.DTO.EntrepriseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ClientEntService {
    ResponseEntity<List<EntrepriseDTO>> getClient();

    ResponseEntity<EntrepriseDTO> deleteSociety(@PathVariable Long id);

    ResponseEntity<EntrepriseDTO> getClientById(@PathVariable Long id);

}
