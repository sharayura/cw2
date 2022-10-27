import java.time.LocalDateTime;

public class DayTask extends Task implements Repeatable{
    public DayTask(String title, String description, LocalDateTime deadline, TaskType taskType) {
        super(title, description, deadline, taskType);
        setRepeatType(RepeatType.REPEAT_DAY);
    }

    @Override
    public LocalDateTime getNextTime() {
        return getDeadline().plusDays(1);
    }
}
