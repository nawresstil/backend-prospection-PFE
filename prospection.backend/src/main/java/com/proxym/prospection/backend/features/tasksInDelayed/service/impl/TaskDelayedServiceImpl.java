package com.proxym.prospection.backend.features.tasksInDelayed.service.impl;

import com.proxym.prospection.backend.features.DTO.TacheDTO;
import com.proxym.prospection.backend.features.task.dao.entities.TacheS;
import com.proxym.prospection.backend.features.task.dao.repository.TacheSocRepository;
import com.proxym.prospection.backend.features.tasksInDelayed.service.TaskDelayedService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskDelayedServiceImpl implements TaskDelayedService {
    @Autowired
    private final ModelMapper modelMapper;
    @Autowired

    private final TacheSocRepository tacheSocRepository;

    public TaskDelayedServiceImpl(ModelMapper modelMapper, TacheSocRepository tacheSocRepository) {
        this.modelMapper = modelMapper;
        this.tacheSocRepository = tacheSocRepository;
    }

    @Override
    public ResponseEntity<List<TacheDTO>> getTasksDelayed() {
        List<TacheS> tasks = tacheSocRepository.findDelayedTasks();
        List<TacheDTO> tacheTerList = tasks.stream()
                .map(task -> modelMapper.map(task, TacheDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(tacheTerList);
    }


}
