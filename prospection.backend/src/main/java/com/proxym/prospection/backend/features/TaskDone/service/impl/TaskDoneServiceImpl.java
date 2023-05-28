package com.proxym.prospection.backend.features.TaskDone.service.impl;


import com.proxym.prospection.backend.features.DTO.TacheDTO;
import com.proxym.prospection.backend.features.TaskDone.service.TaskDoneService;
import com.proxym.prospection.backend.features.task.dao.entities.TacheS;
import com.proxym.prospection.backend.features.task.dao.repository.TacheSocRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskDoneServiceImpl implements TaskDoneService {
    @Autowired
    private final ModelMapper modelMapper;
    @Autowired

    private final TacheSocRepository tacheSocRepository;

    public TaskDoneServiceImpl(ModelMapper modelMapper, TacheSocRepository tacheSocRepository) {
        this.modelMapper = modelMapper;
        this.tacheSocRepository = tacheSocRepository;
    }

    @Override
    public ResponseEntity<List<TacheDTO>> getTasksdone() {
        List<TacheS> tasks = tacheSocRepository.findTasksDone();
        List<TacheDTO> tacheTerList = tasks.stream()
                .map(task -> modelMapper.map(task, TacheDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(tacheTerList);
    }


}
