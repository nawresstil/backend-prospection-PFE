package com.proxym.prospection.backend.features.task.controllers;

import com.proxym.prospection.backend.features.task.dao.entities.TacheS;
import com.proxym.prospection.backend.features.task.service.TacheSocService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @RequestMapping("/tacheSoc")
    @Slf4j
    public class TacheSocController {
        private final TacheSocService tacheSocService;

        public TacheSocController(TacheSocService tacheSocService) {
            this.tacheSocService = tacheSocService;
        }

        @PostMapping("/add")
        public TacheS createTacheS(@RequestBody TacheS tacheS) {

            return tacheSocService.createTacheS(tacheS,tacheS.getContact(), tacheS.getCollaborateurs());
        }

        @GetMapping("/all")
        public ResponseEntity<List<TacheS>> getAllTaches() {

            return tacheSocService.getAllTaches();
        }

        @GetMapping("/{id}")
        public ResponseEntity<TacheS> getTacheSById(@PathVariable Long id)
        {

            return tacheSocService.getTacheSById(id);
        }

        @PutMapping("/update/{id}")
        public TacheS updateTacheS(@RequestBody TacheS tacheSDetails,@PathVariable Long id) {
            return tacheSocService.modifier(tacheSDetails,id,tacheSDetails.getContact(),tacheSDetails.getCollaborateurs());
        }
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<TacheS> deleteClient(@PathVariable Long id) {

            return tacheSocService.deleteTacheS(id);
        }
//        @PutMapping("/{taskId}/enterprise")
//        public void updateTaskEnterprise(@PathVariable Long taskId, @RequestBody UpdateTaskEnterpriseRequest request) {
//            tacheSocService.updateTaskWithEnterpriseName(taskId, request.getEnterpriseName());
//        }

    }
