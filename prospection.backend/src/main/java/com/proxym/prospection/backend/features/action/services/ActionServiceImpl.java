package com.proxym.prospection.backend.features.action.services;

import com.proxym.prospection.backend.features.action.dao.entities.Action;
import com.proxym.prospection.backend.features.action.dao.repositories.ActionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ActionServiceImpl implements ActionService {
    private final ActionRepository actionRepository;

    public ActionServiceImpl(ActionRepository actionRepository) {

        this.actionRepository = actionRepository;
    }

    @Override
    public ResponseEntity<List<Action>> getAllActions() {

        List<Action> action = actionRepository.findAll();


        return ResponseEntity.ok().body(action);
    }

    @Override
    public Action createAction(@RequestBody Action action) {
//        entreprise.setTacheS(new HashSet<TacheS>() {}); //when create entreprise add id tacheS
    return actionRepository.save(action);
    }

    @Override
    public ResponseEntity<Action> getActionById(@PathVariable Long id) {
        Action action = actionRepository.findById(id).orElse(null);

        if (action == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(action);
    }

    @Override
    public Action updateAction(Action actionDetails, Long id) {
        actionDetails.setId(id);
        return actionRepository.saveAndFlush(actionDetails);
    }

    @Override

    public ResponseEntity<Action> deleteAction(@PathVariable Long id) {
        Action action = actionRepository.findById(id).orElse(null);

        if (action == null) {
            return ResponseEntity.notFound().build();
        }
        actionRepository.delete(action);
        return ResponseEntity.ok().build();
    }


}
