import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class SingleTask extends Task {
    public SingleTask(String title, String description, LocalDateTime deadline, TaskType taskType)
            throws IOException {
        super(title, description, deadline, taskType);
        setRepeatType(RepeatType.REPEAT_SINGLE);
    }

    @Override
    public LocalDateTime getNextTime() {
        return null;
    }

    @Override
    public LocalDate getNextData(LocalDate localDate) {
        return null;
    }

}
