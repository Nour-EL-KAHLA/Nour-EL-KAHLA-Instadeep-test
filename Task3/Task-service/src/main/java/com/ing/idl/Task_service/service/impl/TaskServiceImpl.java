package com.ing.idl.Task_service.service.impl;

import com.ing.idl.Task_service.dto.PageableDto;
import com.ing.idl.Task_service.dto.TaskDto;
import com.ing.idl.Task_service.entity.TaskEntity;
import com.ing.idl.Task_service.mapper.impl.TaskMapper;
import com.ing.idl.Task_service.repository.TaskRepository;
import com.ing.idl.Task_service.service.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository productRepository, TaskMapper productMapper) {
        this.taskRepository = productRepository;
        this.taskMapper = productMapper;
    }

    @Override
    public TaskDto addTask(TaskDto taskDto) {
        TaskEntity taskEntity = taskMapper.toEntity(taskDto);
        TaskEntity product = taskRepository.save(taskEntity);
        return taskMapper.toDto(product);
    }

    @Override
    public Page<TaskDto> getAllTask(PageableDto pageableDto) {
        Page<TaskEntity> taskEntityPage = taskRepository.findAll(pageableDto);
        List<TaskDto> productDtos = taskMapper.toDto(taskEntityPage.getContent());
        return new PageImpl<>(productDtos, pageableDto, taskEntityPage.getTotalElements());

    }


    @Override
    public TaskDto updateTask(TaskDto taskDto) {
        if(!taskRepository.existsById(taskDto.getId())){
            return null;
        }
        TaskEntity productEntity = taskMapper.toEntity(taskDto);
        taskRepository.save(productEntity);
        return taskMapper.toDto(productEntity);
    }

    @Override
    public void deleteTask(Long id) {
    taskRepository.deleteById(id);
    }
}
