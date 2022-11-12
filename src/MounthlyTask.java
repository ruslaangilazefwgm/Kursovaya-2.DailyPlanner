import java.time.LocalDate;
import java.time.LocalDateTime;

public class MounthlyTask extends Task {
    public MounthlyTask(String name, String description, String type, LocalDateTime taskDateTime) {
        super(name, description, type, taskDateTime);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        final LocalDate taskCreationDate = getTaskDateTime().toLocalDate();
        return taskCreationDate.getDayOfMonth() == date.getDayOfMonth() || (taskCreationDate.isBefore(date));
    }

    @Override
    public String getTaskRepeat() {
        return "Ежемесячная";
    }
}
