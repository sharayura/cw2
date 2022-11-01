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
        taskCollection.get(id).setDeleted();
    }

    public static void printTasksByTime(LocalDateTime time) {
        LocalDate localDate = LocalDate.from(time);
        int count = 0;
        for (Map.Entry<Integer, Task> taskEntry : taskCollection.entrySet()) {
            if (taskEntry.getValue().isTaskOnDay(localDate)) {
                if (count == 0) {
                    System.out.println("Задачи на " + localDate + ":");
                }
                count++;
                System.out.println("id=" + taskEntry.getKey() + " \"" + taskEntry.getValue().getTitle() + "\" - "
                        + taskEntry.getValue().getRepeatType().getDescription());
            }

        }
        if (count == 0) {
            System.out.println("На " + localDate + " нет задач");
        }
    }

    public static void printDeletedTasks() {
        for (Map.Entry<Integer, Task> taskEntry : taskCollection.entrySet()) {
            if (taskEntry.getValue().isDeleted()) {
                System.out.println("id=" + taskEntry.getKey() + "\"" + taskEntry.getValue().getTitle() + "\"");
            }
        }
    }
}
