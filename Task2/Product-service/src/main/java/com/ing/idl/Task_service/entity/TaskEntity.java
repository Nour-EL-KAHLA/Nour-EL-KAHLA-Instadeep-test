package com.ing.idl.Task_service.entity;

import jakarta.persistence.*;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "task")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     private Long Title;
     private Long Description;
     private Epriority Priority;

    private List<Ecategory> Category;
    private Date Date;
    private Long Status;
}
