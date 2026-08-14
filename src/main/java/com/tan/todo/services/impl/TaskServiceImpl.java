package com.tan.todo.services.impl;

import com.tan.todo.domain.entites.Task;
import com.tan.todo.domain.entites.TaskList;
import com.tan.todo.domain.entites.TaskPriority;
import com.tan.todo.domain.entites.TaskStatus;
import com.tan.todo.repositories.TaskListRepository;
import com.tan.todo.repositories.TaskRepository;
import com.tan.todo.services.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskListRepository taskListRepository;

    public TaskServiceImpl(TaskRepository taskRepository, TaskListRepository taskListRepository) {
        this.taskRepository = taskRepository;
        this.taskListRepository = taskListRepository;
    }

    @Override
    public List<Task> listTask(UUID taskListId) {

        return taskRepository.findByTaskListId(taskListId);
    }

    @Override
    public Task createTask(UUID taskListId, Task task) {
        if(null != task.getId()){
            throw new IllegalArgumentException("task already has Id");
        }
        if(null == task.getTitle() || task.getTitle().isBlank()){
            throw new IllegalArgumentException("Title is necessary");
        }

        TaskPriority taskPriority = Optional.ofNullable(task.getPriority()).orElse(TaskPriority.MEDIUM);
        TaskStatus taskStatus = TaskStatus.OPEN;

        TaskList taskList = taskListRepository.findById(taskListId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid task list ID provided!"));

        LocalDateTime now = LocalDateTime.now();

        Task taskToSave = new Task(
                null,
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                taskStatus,
                taskPriority,
                taskList,
                now,
                now
        );
        return taskRepository.save(taskToSave);
    }

    @Override
    public Optional<Task> getTask(UUID taskListId, UUID taskId) {
        return taskRepository.findByTaskListIdAndId(taskListId, taskId);
    }

    @Override
    public Task updateTask(UUID taskListId, UUID taskId, Task task) {
        if(null == task.getId()){
            throw new IllegalArgumentException("Task must have id");
        }

        if(!Objects.equals(taskId, task.getId())){
            throw new IllegalArgumentException("IDs do not match!");
        }

        if(null == task.getPriority()){
            throw new IllegalArgumentException(("Task must have a priority!"));
        }

        if(null == task.getStatus()){
            throw new IllegalArgumentException("Task should a status");
        }

        Task exisitngTask = taskRepository.findByTaskListIdAndId(taskListId, taskId)
                .orElseThrow(() -> new IllegalArgumentException("Task doesnt exist!"));

        exisitngTask.setTitle(task.getTitle());
        exisitngTask.setDescription(task.getDescription());
        exisitngTask.setDueDate(task.getDueDate());
        exisitngTask.setPriority(task.getPriority());
        exisitngTask.setStatus(task.getStatus());
        exisitngTask.setUpdatedTime(LocalDateTime.now());

        return taskRepository.save(exisitngTask);

    }

    @Override
    public void deleteTask(UUID taskListId, UUID taskId) {
//        taskRepository.deleteAllById(taskId);
        taskRepository.deleteByTaskListIdAndId(taskListId, taskId);
    }
}
