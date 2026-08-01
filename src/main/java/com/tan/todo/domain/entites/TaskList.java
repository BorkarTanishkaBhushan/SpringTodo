package com.tan.todo.domain.entites;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "task_list")
public class TaskList {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

//   One task list contains many tasks
//   Task list can have multiple task
//    Mappedby: "The relationship is managed by the taskList field inside the Task class."
    @OneToMany(mappedBy = "taskList", cascade = {
            CascadeType.REMOVE, CascadeType.PERSIST
    })
    private List<Task> tasks;

    @Column(name = "created_time", nullable = false, updatable = false)
    private LocalDateTime created_time;

    @Column(name = "updated_time", nullable = false)
    private LocalDateTime updated_time;

    public TaskList() {
    }

    public TaskList(UUID id, String title, String description, List<Task> tasks, LocalDateTime created_time, LocalDateTime updated_time){
        this.id = id;
        this.title = title;
        this.description = description;
        this.tasks = tasks;
        this.created_time = created_time;
        this.updated_time = updated_time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public LocalDateTime getCreated_time() {
        return created_time;
    }

    public void setCreated_time(LocalDateTime created_time) {
        this.created_time = created_time;
    }

    public LocalDateTime getUpdated_time() {
        return updated_time;
    }

    public void setUpdated_time(LocalDateTime updated_time) {
        this.updated_time = updated_time;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TaskList taskList = (TaskList) o;
        return Objects.equals(id, taskList.id) && Objects.equals(title, taskList.title) && Objects.equals(description, taskList.description) && Objects.equals(tasks, taskList.tasks) && Objects.equals(created_time, taskList.created_time) && Objects.equals(updated_time, taskList.updated_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, tasks, created_time, updated_time);
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", tasks=" + tasks +
                ", created_time=" + created_time +
                ", updated_time=" + updated_time +
                '}';
    }
}
