package com.proxym.prospection.backend.features.taskTodo.controllers;

import com.proxym.prospection.backend.features.DTO.TacheDTO;
import com.proxym.prospection.backend.features.taskTodo.service.TaskTodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/task-todo-after")
@Slf4j
public class TaskTodoController {

    @Autowired
    private final TaskTodoService taskTodoService;

    public TaskTodoController(TaskTodoService taskTodoService) {

        this.taskTodoService = taskTodoService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<TacheDTO>> getTasksToDoAfterToday() {
        return taskTodoService.getTasksToDoAfterToday();
    }
}
