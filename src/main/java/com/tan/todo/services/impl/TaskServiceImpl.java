package com.tan.todo.services.impl;

import com.tan.todo.domain.entites.Task;
import com.tan.todo.repositories.TaskRepository;
import com.tan.todo.services.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> listTask(UUID taskListId) {

        return taskRepository.findByTaskListId(taskListId);
    }
}
