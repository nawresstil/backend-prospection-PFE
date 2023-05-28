package com.proxym.prospection.backend.features.tasksInDelayed.service;


import com.proxym.prospection.backend.features.DTO.TacheDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskDelayedService {
    ResponseEntity<List<TacheDTO>> getTasksDelayed();
}
