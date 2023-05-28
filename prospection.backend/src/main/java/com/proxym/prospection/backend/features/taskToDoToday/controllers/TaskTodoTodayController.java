package com.proxym.prospection.backend.features.taskToDoToday.controllers;

import com.proxym.prospection.backend.features.DTO.TacheDTO;
import com.proxym.prospection.backend.features.taskToDoToday.service.TaskTodoTodayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks-todo-today")
@Slf4j
public class TaskTodoTodayController {

    @Autowired
    private final TaskTodoTodayService taskTodoTodayService;

    public TaskTodoTodayController(TaskTodoTodayService taskTodoTodayService) {

        this.taskTodoTodayService = taskTodoTodayService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<TacheDTO>> getTasksToDoToday() {
        return taskTodoTodayService.getTasksTodoToday();
    }
}
