import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeekTask extends Task {
    public WeekTask(String title, String description, LocalDateTime deadline, TaskType taskType)
            throws IOException {
        super(title, description, deadline, taskType);
        setRepeatType(RepeatType.REPEAT_WEEK);
    }

    @Override
    public LocalDateTime getNextTime() {
        return getDeadline().plusWeeks(1);
    }

    @Override
    public LocalDate getNextData(LocalDate localDate) {
        return localDate.plusWeeks(1);
    }

}
