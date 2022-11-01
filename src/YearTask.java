import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearTask extends Task {
    public YearTask(String title, String description, LocalDateTime deadline, TaskType taskType)
            throws IOException {
        super(title, description, deadline, taskType);
        setRepeatType(RepeatType.REPEAT_YEAR);
    }

    @Override
    public LocalDateTime getNextTime() {
        if (isDeleted()) {
            return null;
        }
        return getDeadline().plusYears(1);
    }

    @Override
    public LocalDate getNextDate(LocalDate localDate) {
        if (isDeleted()) {
            return null;
        }
        return localDate.plusYears(1);
    }

}
