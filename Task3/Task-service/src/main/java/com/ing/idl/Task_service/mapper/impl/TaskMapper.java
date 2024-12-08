package com.ing.idl.Task_service.mapper.impl;


import com.ing.idl.Task_service.dto.TaskDto;
import com.ing.idl.Task_service.entity.TaskEntity;
import com.ing.idl.Task_service.mapper.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper extends GenericMapper<TaskEntity, TaskDto> {
}
