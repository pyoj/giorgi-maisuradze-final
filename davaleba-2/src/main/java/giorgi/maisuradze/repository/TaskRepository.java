package giorgi.maisuradze.repository;

import giorgi.maisuradze.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
