package com.ing.idl.Task_service.controller;

import com.ing.idl.Task_service.dto.ApiResponse;
import com.ing.idl.Task_service.dto.PageableDto;
import com.ing.idl.Task_service.dto.TaskDto;
import com.ing.idl.Task_service.service.TaskService;
import com.ing.idl.Task_service.util.CheckAuthorization;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<TaskDto>> createProduct(@RequestBody TaskDto productDto) {
        productDto.setId(null);
        TaskDto productCreated = taskService.addTask(productDto);
        ApiResponse<TaskDto> response = new ApiResponse<>(productCreated, "Task have be successfully cre.", true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /*@GetMapping
    public ResponseEntity<ApiResponse<List<ProductDto>>> getAllProducts() {
        return new ResponseEntity<>(
                new ApiResponse<>(productService.getAllProduct(), "List of products", true),
                HttpStatus.OK
        );
    }*/


    @PutMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<TaskDto>> updateProduct(@PathVariable Long id, @RequestBody TaskDto task) {
        task.setId(id);
        TaskDto taskUpdated = taskService.updateTask(task);
        ApiResponse<TaskDto> response = new ApiResponse<>(taskUpdated, "Task updated successfully.", true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse<Void>> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        ApiResponse<Void> response = new ApiResponse<>(null, "Task deleted successfully.", true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //Paginated function
    @CheckAuthorization(allowedCountries = {"US", "FR", "TN"}, blacklistedIps = {"203.0.113.195"})
    @GetMapping
    public ResponseEntity<Page<TaskDto>> getProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String sort
    ){
        PageableDto pageableDto = new PageableDto(page, size, sort);
        Page<TaskDto> taskDtos = taskService.getAllTask(pageableDto);
        return new ResponseEntity<>(taskDtos, HttpStatus.OK);
    }
}
