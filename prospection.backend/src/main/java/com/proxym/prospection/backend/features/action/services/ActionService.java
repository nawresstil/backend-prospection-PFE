package com.proxym.prospection.backend.features.action.services;

import com.proxym.prospection.backend.features.action.dao.entities.Action;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ActionService {

    ResponseEntity<List<Action>> getAllActions();

    Action createAction(Action action, String firstname);

    ResponseEntity<Action> getActionById(@PathVariable Long id);

//  List<String> getAllBySocietyName();
    Action updateAction (@RequestBody Action actionDetails, @PathVariable Long id,String firstname);

    ResponseEntity<Action> deleteAction(@PathVariable Long id);

}