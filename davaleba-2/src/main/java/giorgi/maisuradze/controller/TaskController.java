package giorgi.maisuradze.controller;

import giorgi.maisuradze.dto.task.*;
import giorgi.maisuradze.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("get/all")
    public GetTaskOutput getTasks() {
        return taskService.getTasks();
    }

    @PostMapping("get")
    public GetTaskOutput getTaskById(@RequestBody GetTaskInput getTaskInput) {
        return taskService.getTaskById(getTaskInput);
    }

    @PostMapping("add")
    public AddTaskOutput addTask(@RequestBody AddTaskInput addTaskInput) {
        return taskService.addTask(addTaskInput);
    }

    @DeleteMapping("delete")
    public DeleteTaskOutput deleteTask(@RequestBody DeleteTaskInput deleteTaskInput) {
        return taskService.deleteTask(deleteTaskInput);
    }
}
