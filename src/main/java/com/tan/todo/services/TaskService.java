package com.tan.todo.services;

import com.tan.todo.domain.entites.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    List<Task> listTask(UUID taskListId);
}
