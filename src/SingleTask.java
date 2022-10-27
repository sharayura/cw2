import java.time.LocalDateTime;

public class SingleTask extends Task implements Repeatable{
    public SingleTask(String title, String description, LocalDateTime deadline, TaskType taskType) {
        super(title, description, deadline, taskType);
        setRepeatType(RepeatType.REPEAT_SINGLE);
    }

    @Override
    public LocalDateTime getNextTime() {
        return null;
    }
}
