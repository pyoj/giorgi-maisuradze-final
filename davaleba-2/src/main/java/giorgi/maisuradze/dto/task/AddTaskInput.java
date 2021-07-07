package giorgi.maisuradze.dto.task;

import lombok.Data;

import java.util.Date;

@Data
public class AddTaskInput {

    private String title;

    private String description;

    private Date startDate;

    private Date endDate;
    
}
