import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthTask extends Task {
    public MonthTask(String title, String description, LocalDateTime deadline, TaskType taskType)
            throws IOException {
        super(title, description, deadline, taskType);
        setRepeatType(RepeatType.REPEAT_MONTH);
    }

    @Override
    public LocalDateTime getNextTime() {
        return getDeadline().plusMonths(1);
    }

    @Override
    public LocalDate getNextData(LocalDate localDate) {
        return localDate.plusMonths(1);
    }


}
