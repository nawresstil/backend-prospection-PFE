package com.proxym.prospection.backend.features.action.controllers;

import com.proxym.prospection.backend.features.action.dao.entities.Action;
import com.proxym.prospection.backend.features.action.services.ActionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/action")
@Slf4j
public class ActionController {
    private final ActionService actionService;

    public ActionController(ActionService actionService) {

        this.actionService = actionService;
    }

    @PostMapping("/create")
    public Action createAction(@RequestBody Action action) {
        return actionService.createAction(action, action.getCollaborateur());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Action>> getAllActions() {

        return actionService.getAllActions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Action> getActionById(@PathVariable Long id) {

        return actionService.getActionById(id);
    }

  @PutMapping("/edit/{id}")
    public Action updateActionEntreprise (@RequestBody Action actionDetails, @PathVariable Long id){
    return actionService.updateAction(actionDetails,id, actionDetails.getCollaborateur());
}

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Action> deleteAction(@PathVariable Long id) {

        return actionService.deleteAction(id);
    }

}

