package giorgi.maisuradze.service;

import giorgi.maisuradze.dto.task.*;

public interface TaskService {

    GetTaskOutput getTasks();

    GetTaskOutput getTaskById(GetTaskInput getTaskInput);

    AddTaskOutput addTask(AddTaskInput addTaskInput);
    
    DeleteTaskOutput deleteTask(DeleteTaskInput deleteTaskInput);

}
