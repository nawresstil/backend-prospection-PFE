package com.proxym.prospection.backend.features.taskToDoToday.service;


import com.proxym.prospection.backend.features.DTO.TacheDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskTodoTodayService {
    ResponseEntity<List<TacheDTO>> getTasksTodoToday();
}
