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
        if (isDeleted()) {
            return null;
        }
        return getDeadline().plusMonths(1);
    }

    @Override
    public LocalDate getNextDate(LocalDate localDate) {
        if (isDeleted()) {
            return null;
        }
        return localDate.plusMonths(1);
    }


}
