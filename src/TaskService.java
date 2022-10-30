import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private static final Map<Integer, Task> taskCollection = new HashMap<>();

    public static void addTaskToCollection(Task task) {
        taskCollection.put(task.getId(), task);
    }

    public static int getCollectionSize() {
        return taskCollection.size();
    }

    public static void removeTaskFromCollection(Integer id) {
        taskCollection.remove(id);
    }

    public static void printTasksByTime(LocalDateTime time) {
        LocalDate localDate = LocalDate.from(time);
        System.out.println("Задачи на " + localDate + ":");
        for (Map.Entry<Integer, Task> taskEntry : taskCollection.entrySet()) {
            if (taskEntry.getValue().isTaskOnDay(localDate)) {
                System.out.println("id=" + taskEntry.getKey() + " \"" + taskEntry.getValue().getTitle() + "\"");
            }

        }
    }
}
