package com.tan.todo.mappers;

import com.tan.todo.domain.dto.TaskDto;
import com.tan.todo.domain.entites.Task;

public interface TaskMapper {

    Task fromDto(TaskDto taskDto);
    TaskDto toDto(Task task);
}
