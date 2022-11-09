import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Task {
    private String type;
    private String name;
    private String description;
    private final LocalDateTime taskDateTime;
    private  int id;
    private static int counter = 0;
    public Task(String name, String description, String type, LocalDateTime taskDateTime ) {
        if (name != null & !name.isEmpty()) {
            this.name = name;
        } else throw new RuntimeException("Некорректно введено название");
        if (description != null & !description.isEmpty()) {
            this.description = description;
        } else throw new RuntimeException("Некорректно введено описание");
        this.type = type;
        this.taskDateTime = LocalDateTime.parse(taskDateTime.format(DateTimeFormatter.ofPattern("dd.MM.yy")));
        this.id = counter++;

    }

    public abstract boolean appearsIn(LocalDate date);

    public abstract String getTaskRepeat();

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", time=" + taskDateTime +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(name, task.name) && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getTaskDateTime() {
        return taskDateTime;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
