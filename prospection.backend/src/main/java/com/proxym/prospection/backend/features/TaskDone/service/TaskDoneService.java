package com.proxym.prospection.backend.features.TaskDone.service;


import com.proxym.prospection.backend.features.DTO.TacheDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskDoneService {
    ResponseEntity<List<TacheDTO>> getTasksdone();
}
