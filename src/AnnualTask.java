import java.time.LocalDate;
import java.time.LocalDateTime;

public class AnnualTask extends Task{
    public AnnualTask(String name, String description, String type, LocalDateTime taskDateTime) {
        super(name, description, type, taskDateTime);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        final LocalDate taskCreationDate = getTaskDateTime().toLocalDate();
        return taskCreationDate.getDayOfYear() == date.getDayOfYear() || (taskCreationDate.isBefore(date));
    }

    @Override
    public String getTaskRepeat() {
        return "Ежегодная";
    }
}
