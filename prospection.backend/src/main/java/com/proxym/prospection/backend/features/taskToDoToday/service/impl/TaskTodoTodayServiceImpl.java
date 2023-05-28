package com.proxym.prospection.backend.features.taskToDoToday.service.impl;


import com.proxym.prospection.backend.features.DTO.TacheDTO;
import com.proxym.prospection.backend.features.task.dao.entities.TacheS;
import com.proxym.prospection.backend.features.task.dao.repository.TacheSocRepository;
import com.proxym.prospection.backend.features.taskToDoToday.service.TaskTodoTodayService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskTodoTodayServiceImpl implements TaskTodoTodayService {
    @Autowired
    private final ModelMapper modelMapper;
    @Autowired

    private final TacheSocRepository tacheSocRepository;

    public TaskTodoTodayServiceImpl(ModelMapper modelMapper, TacheSocRepository tacheSocRepository) {
        this.modelMapper = modelMapper;
        this.tacheSocRepository = tacheSocRepository;
    }

    @Override
    public ResponseEntity<List<TacheDTO>> getTasksTodoToday() {
        List<TacheS> tasksToday = tacheSocRepository.findTasksTodoToday();
        List<TacheDTO> tasksTodayList = tasksToday.stream()
                .map(task -> modelMapper.map(task, TacheDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(tasksTodayList);
    }
}
