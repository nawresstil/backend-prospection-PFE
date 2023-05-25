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

//    @Transactional
//    void updateTaskWithEnterpriseName(Long taskId, String enterpriseName);

    ResponseEntity<TacheS> updateTacheS(@PathVariable Long id, @RequestBody TacheS tacheSDetails);

    ResponseEntity<TacheS> deleteTacheS(@PathVariable Long id);
}
