package com.tan.todo.services;

import com.tan.todo.domain.entites.TaskList;

import java.util.List;

public interface TaskListService {
    List<TaskList> listTaskLists();
    TaskList createTaskList(TaskList taskList);
}
