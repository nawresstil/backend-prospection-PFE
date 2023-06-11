package com.proxym.prospection.backend.features.action.services;

import com.proxym.prospection.backend.features.action.dao.entities.Action;
import com.proxym.prospection.backend.features.action.dao.repositories.ActionRepository;
import com.proxym.prospection.backend.features.company.dao.entities.Entreprise;
import com.proxym.prospection.backend.features.user.dao.entities.User;
import com.proxym.prospection.backend.features.user.dao.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ActionServiceImpl implements ActionService {
    private final ActionRepository actionRepository;
    private final UserRepository userRepository;

    public ActionServiceImpl(ActionRepository actionRepository, UserRepository userRepository) {

        this.actionRepository = actionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<List<Action>> getAllActions() {

        List<Action> action = actionRepository.findAll();


        return ResponseEntity.ok().body(action);
    }

    @Override
    public Action createAction(Action action,  String firstname) {
        User user = userRepository.findUserByUsername(firstname);
        action.setUser(user);
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
    public Action updateAction(Action actionDetails, Long id,String firstname) {
        User user = userRepository.findUserByUsername(firstname);
        actionDetails.setUser(user);
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
