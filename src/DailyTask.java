import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task{
    public DailyTask(String name, String description, Type type, LocalDateTime taskDateTime) {
        super(name, description, type, taskDateTime);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        final LocalDate taskCreationDate = getTaskDateTime().toLocalDate();
        return taskCreationDate.equals(date) || (taskCreationDate.isBefore(date));
    }

    @Override
    public String getTaskRepeat() {
        return "Ежедневная";
    }
}
