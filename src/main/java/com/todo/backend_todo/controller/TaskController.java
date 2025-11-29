    package com.todo.backend_todo.controller;

    import com.todo.backend_todo.entity.Task;
    import com.todo.backend_todo.service.TaskService;
    import org.springframework.web.bind.annotation.*;
    import tools.jackson.databind.ObjectMapper;

    import java.util.List;

    @RestController
    @RequestMapping("/tasks")
    @CrossOrigin("*")
    public class TaskController {
        private TaskService theTaskService;
//        private ObjectMapper theObjectMapper;

        public TaskController(TaskService theTaskService) {
            this.theTaskService = theTaskService;
//            this.theObjectMapper = theObjectMapper;
        }

        @GetMapping
        public List<Task> getAllTasks(){
            return theTaskService.getAllTasks();
        }
        @GetMapping("/{id}")
        public Task getTaskById(@PathVariable Integer id){
            return theTaskService.getTaskById(id);
        }
        @DeleteMapping("/{id}")
        public void deleteTaskById(@PathVariable Integer id){
            theTaskService.deleteTaskById(id);
        }
        @PostMapping
        public Task createTask(@RequestBody Task task){
            return theTaskService.createTask(task);
        }
        @PutMapping("/{id}")
        public Task updateTask(@PathVariable Integer id,@RequestBody Task task){
            return theTaskService.updateTask(id,task);
        }
        @PatchMapping("/{id}/toggle")
        public Task toggleTaskCompletion(@PathVariable Integer id){
            return  theTaskService.toggleTaskCompletion(id);

        }




    }
