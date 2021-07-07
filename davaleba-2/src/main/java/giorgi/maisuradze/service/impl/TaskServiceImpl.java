package giorgi.maisuradze.service.impl;

import giorgi.maisuradze.dto.task.*;
import giorgi.maisuradze.model.Task;
import giorgi.maisuradze.repository.TaskRepository;
import giorgi.maisuradze.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public GetTaskOutput getTasks() {
        List<TaskDTO> tasksList = new ArrayList<>();

        for (Task task : taskRepository.findAll()) {
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setId(task.getId());
            taskDTO.setTitle(task.getTitle());
            taskDTO.setDescription(task.getDescription());
            taskDTO.setStartDate(task.getStartDate());
            taskDTO.setEndDate(task.getEndDate());
            tasksList.add(taskDTO);
        }

        GetTaskOutput getTaskOutput = new GetTaskOutput();
        getTaskOutput.setTasks(tasksList);

        return getTaskOutput;
    }


    @Override
    public GetTaskOutput getTaskById(GetTaskInput getTaskInput) {
        TaskDTO taskDTO = new TaskDTO();

        Task task = taskRepository.getById(getTaskInput.getId());

        taskDTO.setId(task.getId());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setStartDate(task.getStartDate());
        taskDTO.setEndDate(task.getEndDate());

        GetTaskOutput getTaskOutput = new GetTaskOutput();
        getTaskOutput.setTasks(Collections.singletonList(taskDTO));

        return getTaskOutput;
    }

    @Override
    public AddTaskOutput addTask(AddTaskInput addTaskInput) {
        Task task = new Task();
        task.setTitle(addTaskInput.getTitle());
        task.setDescription(addTaskInput.getDescription());
        task.setStartDate(addTaskInput.getStartDate());
        task.setEndDate(addTaskInput.getEndDate());

        taskRepository.save(task);

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setStartDate(task.getStartDate());
        taskDTO.setEndDate(task.getEndDate());

        AddTaskOutput addTaskOutput = new AddTaskOutput();
        addTaskOutput.setMessage("თასქი დაემატა!");
        addTaskOutput.setTask(taskDTO);

        return addTaskOutput;
    }

    @Override
    public DeleteTaskOutput deleteTask(DeleteTaskInput deleteTaskInput) {
        Task task;
        DeleteTaskOutput deleteTaskOutput = new DeleteTaskOutput();

        Optional<Task> taskOptional = taskRepository.findById(deleteTaskInput.getId());

        if (taskOptional.isPresent()) {
            task = taskOptional.get();
            taskRepository.delete(task);

            deleteTaskOutput.setMessage("თასქი წაიშალა");
        } else {
            deleteTaskOutput.setMessage("თასქი მოცემული აიდით არ არსებობს!");
        }

        return deleteTaskOutput;
    }
}
