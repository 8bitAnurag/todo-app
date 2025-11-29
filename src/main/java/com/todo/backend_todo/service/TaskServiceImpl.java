package com.todo.backend_todo.service;

import com.todo.backend_todo.entity.Task;
import com.todo.backend_todo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    private TaskRepository taskRepository;
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Integer id) {
        return taskRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteTaskById(Integer id) {
         taskRepository.deleteById(id);

    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Integer id, Task task) {
        Task existingTask = getTaskById(id);
        existingTask.setTaskName(task.getTaskName());
        return taskRepository.save(existingTask);
    }

    @Override
    public Task toggleTaskCompletion(Integer id) {
        Task task = getTaskById(id);
        task.setCompleted(!task.isCompleted());
        return taskRepository.save(task);
    }
}
