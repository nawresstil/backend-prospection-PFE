package com.proxym.prospection.backend.features.task.service.impl;

import com.proxym.prospection.backend.features.company.dao.entities.Entreprise;
import com.proxym.prospection.backend.features.company.dao.repositories.EntrepriseRepository;
import com.proxym.prospection.backend.features.task.dao.entities.TacheS;
import com.proxym.prospection.backend.features.task.dao.repository.TacheSocRepository;
import com.proxym.prospection.backend.features.task.service.TacheSocService;
import com.proxym.prospection.backend.features.user.dao.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TacheSocServiceImpl implements TacheSocService {

    private final TacheSocRepository tacheSocRepository;

    //  private final ProspectRepository prospectRepository;
    private final EntrepriseRepository entrepriseRepository;
    private final UserRepository userRepository;


    public TacheSocServiceImpl(TacheSocRepository tacheSocRepository, EntrepriseRepository entrepriseRepository, UserRepository userRepository) {

        this.tacheSocRepository = tacheSocRepository;
        this.entrepriseRepository = entrepriseRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<List<TacheS>> getAllTaches() {

        List<TacheS> tacheS = tacheSocRepository.findAll();


        return ResponseEntity.ok().body(tacheS);
    }

    @Override
    public TacheS createTacheS(TacheS tacheS, String societyName, String firstname) {
        Entreprise society = entrepriseRepository.findSocietyBySocietyName(societyName);
        tacheS.setEntreprise(society); // to add id-entreprise
        society.getTacheS().add(tacheS); //to add task to entreprise
//        User user = userRepository.findUserByFirstname(firstname);
//        tacheS.setUser(user); // to add id-user
//        user.getTacheS().add(tacheS); //to add task to user
        return tacheSocRepository.save(tacheS);
    }
    @Override
    public ResponseEntity<TacheS> getTacheSById(@PathVariable Long id) {
        TacheS tacheS = tacheSocRepository.findById(id).orElse(null);

        if (tacheS == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(tacheS);
    }
//    @Override
//    @Transactional
//    public void updateTaskWithEnterpriseName(Long taskId, String enterpriseName) {
//        TacheS task = tacheSocRepository.findById(taskId)
//                .orElseThrow(() -> new IllegalArgumentException("Task not found with ID: " + taskId));
//
//        Entreprise enterprise = entrepriseRepository.findSocietyBySocietyName(enterpriseName);
//
//        task.setEntreprise(enterprise);
//
//        tacheSocRepository.save(task);
//        System.out.println("Task updated successfully with enterprise name: " + enterpriseName);
//    }
    @Override
    public ResponseEntity<TacheS> updateTacheS(@PathVariable Long id, @RequestBody TacheS tacheSDetails) {
        TacheS tacheS = tacheSocRepository.findById(id).orElse(null);

        if (tacheS == null) {
            return ResponseEntity.notFound().build();
        }
        tacheS.setLabel(tacheSDetails.getLabel());
        tacheS.setCollaborateurs(tacheSDetails.getCollaborateurs());
        tacheS.setDate(tacheSDetails.getDate());
        tacheS.setContact(tacheSDetails.getContact());
        tacheS.setTitre(tacheSDetails.getTitre());
        tacheS.setDescription(tacheSDetails.getDescription());
        tacheS.setEntreprise(tacheSDetails.getEntreprise());
        tacheS.setEtat(tacheSDetails.getEtat());
        tacheS.setComment(tacheSDetails.getComment());
        tacheS.setFiles(tacheSDetails.getFiles());
        TacheS updateTacheS = tacheSocRepository.save(tacheS);
        return ResponseEntity.ok(updateTacheS);
    }
    @Override
    public ResponseEntity<TacheS> deleteTacheS(@PathVariable Long id) {
        TacheS tacheS = tacheSocRepository.findById(id).orElse(null);

        if (tacheS == null) {
            return ResponseEntity.notFound().build();
        }
        tacheSocRepository.delete(tacheS);

        return ResponseEntity.ok().build();
    }
}
