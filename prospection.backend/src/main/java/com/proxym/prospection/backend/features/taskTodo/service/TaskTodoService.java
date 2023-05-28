package com.proxym.prospection.backend.features.taskTodo.service;

import com.proxym.prospection.backend.features.DTO.TacheDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskTodoService {
    ResponseEntity<List<TacheDTO>> getTasksToDoAfterToday();
}
