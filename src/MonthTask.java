import java.time.LocalDateTime;

public class MonthTask extends Task implements Repeatable{
    public MonthTask(String title, String description, LocalDateTime deadline, TaskType taskType) {
        super(title, description, deadline, taskType);
        setRepeatType(RepeatType.REPEAT_MONTH);
    }

    @Override
    public LocalDateTime getNextTime() {
        return getDeadline().plusMonths(1);
    }
}
