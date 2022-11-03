import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskService {
    private final Map<Integer, Task> taskCollection = new HashMap<>();

    public void addTaskToCollection(Task task) {
        taskCollection.put(task.getId(), task);
    }

    public int getCollectionSize() {
        return taskCollection.size();
    }

    public void removeTaskFromCollection(Integer id) {
        taskCollection.remove(id);
    }

    public List<Task> tasksByTime(LocalDate time) {
        List<Task> taskList = new ArrayList<>();
        for (Map.Entry<Integer, Task> taskEntry : taskCollection.entrySet()) {
            if (taskEntry.getValue().isTaskOnDay(time)) {
                taskList.add(taskEntry.getValue());
            }
        }
        return taskList;
    }
}
