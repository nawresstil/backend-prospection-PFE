package com.proxym.prospection.backend.features.task.service.impl;

import com.proxym.prospection.backend.features.company.dao.entities.Entreprise;
import com.proxym.prospection.backend.features.company.dao.repositories.EntrepriseRepository;
import com.proxym.prospection.backend.features.task.dao.entities.TacheS;
import com.proxym.prospection.backend.features.task.dao.repository.TacheSocRepository;
import com.proxym.prospection.backend.features.task.service.TacheSocService;
import com.proxym.prospection.backend.features.user.dao.entities.User;
import com.proxym.prospection.backend.features.user.dao.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
//        society.getTacheS().add(tacheS); //to add task to entreprise
        User user = userRepository.findUserByUsername(firstname);
        tacheS.setUser(user); // to add id-user
//        user.getTacheS().add(tacheS); //to add task to user
        return tacheSocRepository.save(tacheS);
    }
    @Override
    public TacheS modifier(TacheS tacheSDetails, Long id,String societyName,String firstName) {
        Entreprise society = entrepriseRepository.findSocietyBySocietyName(societyName);
        tacheSDetails.setEntreprise(society);
        User user = userRepository.findUserByUsername(firstName);
        tacheSDetails.setUser(user);
    //  TacheS tacheS = tacheSocRepository.findById(id).orElse(null);
        tacheSDetails.setId(id);
        return tacheSocRepository.saveAndFlush(tacheSDetails);
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
    public ResponseEntity<TacheS> deleteTacheS(@PathVariable Long id) {
        TacheS tacheS = tacheSocRepository.findById(id).orElse(null);

        if (tacheS == null) {
            return ResponseEntity.notFound().build();
        }
        tacheSocRepository.delete(tacheS);

        return ResponseEntity.ok().build();
    }
}
