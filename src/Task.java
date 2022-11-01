import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Task {

    private String title;
    private String description;
    private LocalDateTime deadline;
    private static int idCount = 0;
    private final Integer id = idCount;
    private TaskType taskType;
    private RepeatType repeatType;
    private boolean isDeleted = false;

    public enum TaskType {
        TYPE_PRIVATE,
        TYPE_WORK
    }

    public enum RepeatType {
        REPEAT_SINGLE("однократная"),
        REPEAT_DAY("ежедневная"),
        REPEAT_WEEK("еженедельная"),
        REPEAT_MONTH("ежемесячная"),
        REPEAT_YEAR("ежегодная");

        private String description;

        RepeatType(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public Task(String title, String description, LocalDateTime deadline, TaskType taskType) throws IOException {
        if (title == null || title.isBlank()) {
            throw new IOException("Заголовок задачи введен некорректно!");
        } else {
            this.title = title;
        }
        if (description == null || description.isBlank()) {
            throw new IOException("Описание задачи введено некорректно!");
        } else {
            this.description = description;
        }
        this.deadline = deadline;
        if (taskType == null) {
            throw new IOException("Тип задачи введен некорректно!");
        } else {
            this.taskType = taskType;
        }
        idCount++;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted() {
        isDeleted = true;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public static int getIdCount() {
        return idCount;
    }

    public int getId() {
        return id;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public RepeatType getRepeatType() {
        return repeatType;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public void setRepeatType(RepeatType repeatType) {
        this.repeatType = repeatType;
    }

    public abstract LocalDateTime getNextTime();

    public abstract LocalDate getNextDate(LocalDate localDate);
    public Boolean isTaskOnDay(LocalDate localDate) {
        if (isDeleted() || deadline == null) {
            return false;
        }
        LocalDate nextTime = LocalDate.from(deadline);
        while (!nextTime.isAfter(localDate) && nextTime != null) {
            if (localDate.isEqual(nextTime)) {
                return true;
            }
            nextTime = getNextDate(nextTime);
        }
        return false;
    }


}
