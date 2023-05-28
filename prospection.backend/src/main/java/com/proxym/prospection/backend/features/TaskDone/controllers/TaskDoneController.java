package com.proxym.prospection.backend.features.TaskDone.controllers;


import com.proxym.prospection.backend.features.DTO.TacheDTO;
import com.proxym.prospection.backend.features.TaskDone.service.TaskDoneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks-done")
@Slf4j
public class TaskDoneController {

    @Autowired
    private final TaskDoneService taskDoneService;

    public TaskDoneController(TaskDoneService taskDoneService) {

        this.taskDoneService = taskDoneService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<TacheDTO>> getTasksdone() {
        return taskDoneService.getTasksdone();
    }
}
