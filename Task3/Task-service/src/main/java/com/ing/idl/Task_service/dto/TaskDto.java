package com.ing.idl.Task_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private Long id;

    private Long Title;
    private Long Description;
    private Long Priority;

    private Long Category;
    private java.util.Date Date;
    private Long Status;
}
