import java.time.LocalDateTime;

public class YearTask extends Task implements Repeatable{
    public YearTask(String title, String description, LocalDateTime deadline, TaskType taskType) {
        super(title, description, deadline, taskType);
        setRepeatType(RepeatType.REPEAT_YEAR);
    }

    @Override
    public LocalDateTime getNextTime() {
        return getDeadline().plusYears(1);
    }
}
