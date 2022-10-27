import java.time.LocalDateTime;

public class WeekTask extends Task implements Repeatable{
    public WeekTask(String title, String description, LocalDateTime deadline, TaskType taskType) {
        super(title, description, deadline, taskType);
        setRepeatType(RepeatType.REPEAT_WEEK);
    }

    @Override
    public LocalDateTime getNextTime() {
        return getDeadline().plusWeeks(1);
    }
}
