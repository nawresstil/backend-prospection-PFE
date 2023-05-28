package com.proxym.prospection.backend.features.tasksInDelayed.controllers;

import com.proxym.prospection.backend.features.DTO.TacheDTO;
import com.proxym.prospection.backend.features.tasksInDelayed.service.TaskDelayedService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks-delayed")
@Slf4j
public class TaskDelayedController {

    @Autowired
    private final TaskDelayedService taskDelayedService;

    public TaskDelayedController(TaskDelayedService taskDelayedService) {

        this.taskDelayedService = taskDelayedService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<TacheDTO>> getTasksDelayed() {
        return taskDelayedService.getTasksDelayed();
    }
}
