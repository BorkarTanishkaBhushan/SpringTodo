package com.tan.todo.domain.dto;

import com.tan.todo.domain.entites.TaskPriority;
import com.tan.todo.domain.entites.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

//Simple data carriers used to transfer data between different parts of an application, especially between the client (frontend/Postman) and Spring Boot application.
public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDateTime dueDate,
        TaskPriority priority,
        TaskStatus status
) {
}
