package com.ing.idl.Task_service.service;

import com.ing.idl.Task_service.dto.PageableDto;
import com.ing.idl.Task_service.dto.TaskDto;
import org.springframework.data.domain.Page;

public interface TaskService {
    TaskDto addTask(TaskDto productDto);
    Page<TaskDto> getAllTask(PageableDto pageableDto);

    TaskDto updateTask(TaskDto productDto);
    void deleteTask(Long id);
}
