package com.tan.todo.mappers;

import com.tan.todo.domain.dto.TaskListDto;
import com.tan.todo.domain.entites.TaskList;

public interface TaskListMapper {
   TaskList fromDto(TaskListDto taskListDto);
   TaskListDto toDto(TaskList taskList);
}
