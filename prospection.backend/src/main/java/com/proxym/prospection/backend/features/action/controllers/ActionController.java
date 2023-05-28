package com.proxym.prospection.backend.features.action.controllers;

import com.proxym.prospection.backend.features.action.dao.entities.Action;
import com.proxym.prospection.backend.features.action.services.ActionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/actions")
@Slf4j
public class ActionController {
    private final ActionService actionService;

    public ActionController(ActionService actionService) {

        this.actionService = actionService;
    }

    @PostMapping("/create")
    public Action createEntreprise(@RequestBody Action action) {
        return actionService.createAction(action);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Action>> getAllEntreprises() {

        return actionService.getAllActions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Action> getEntrepriseById(@PathVariable Long id) {

        return actionService.getActionById(id);
    }

  @PutMapping("/edit/{id}")
    public Action updateEntreprise (@RequestBody Action actionDetails, @PathVariable Long id){
    return actionService.updateAction(actionDetails,id);
}

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Action> deleteEntreprise(@PathVariable Long id) {

        return actionService.deleteAction(id);
    }

}

