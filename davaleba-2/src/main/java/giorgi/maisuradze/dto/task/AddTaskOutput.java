package giorgi.maisuradze.dto.task;

import lombok.Data;

@Data
public class AddTaskOutput {
    
    private String message;
    
    private TaskDTO task;
    
}
