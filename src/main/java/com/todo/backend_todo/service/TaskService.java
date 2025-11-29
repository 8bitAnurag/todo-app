package com.todo.backend_todo.service;
import com.todo.backend_todo.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    Task getTaskById(Integer id);
    void deleteTaskById(Integer id);
    Task createTask(Task task );
    Task updateTask(Integer id , Task task);
    Task toggleTaskCompletion(Integer id);


}
