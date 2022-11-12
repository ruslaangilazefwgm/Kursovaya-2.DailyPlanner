import java.time.LocalDate;
import java.time.LocalDateTime;

public class SingleTask extends Task{
    public SingleTask(String name, String description, String type, LocalDateTime taskDateTime) {
        super(name, description, type, taskDateTime );
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return getTaskDateTime().toLocalDate().equals(date);
    }

    @Override
    public String getTaskRepeat() {
        return "Одноразовая";
    }
}
