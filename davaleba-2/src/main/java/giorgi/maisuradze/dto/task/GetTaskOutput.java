package giorgi.maisuradze.dto.task;

import lombok.Data;

import java.util.List;

@Data
public class GetTaskOutput {

    private List<TaskDTO> tasks;

}
