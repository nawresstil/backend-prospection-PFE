package com.proxym.prospection.backend.features.task.service;

import com.proxym.prospection.backend.features.task.dao.entities.TacheS;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TacheSocService {
    ResponseEntity<List<TacheS>> getAllTaches();

    TacheS createTacheS(TacheS tacheS, String societyName, String firstname);

    ResponseEntity<TacheS> getTacheSById(@PathVariable Long id);
    TacheS modifier(@RequestBody TacheS tacheSDetails,@PathVariable Long id,String societyName,String firstName);
//    @Transactional
//    void updateTaskWithEnterpriseName(Long taskId, String enterpriseName);

//    ResponseEntity<TacheS> updateTacheS(@PathVariable Long id, @RequestBody TacheS tacheSDetails);

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


    ResponseEntity<TacheS> deleteTacheS(@PathVariable Long id);
}
