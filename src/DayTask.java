import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DayTask extends Task{
    public DayTask(String title, String description, LocalDateTime deadline, TaskType taskType)
            throws IOException {
        super(title, description, deadline, taskType);
        setRepeatType(RepeatType.REPEAT_DAY);
    }

    @Override
    public LocalDateTime getNextTime() {
        return getDeadline().plusDays(1);
    }

    @Override
    public LocalDate getNextData(LocalDate localDate) {
        return localDate.plusDays(1);
    }

}
