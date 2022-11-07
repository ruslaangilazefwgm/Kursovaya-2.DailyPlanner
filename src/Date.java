import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

public class Date {
    public static void main(String[] args) {
        SingleTask task1 = new SingleTask("task1", "task1",
                Task.Type.PERSONAL,  LocalDateTime.of(2022,11,6,11,30));
        SingleTask task2 = new SingleTask("task2", "task2", Task.Type.PERSONAL,
                 LocalDateTime.of(2022,11,7,11,30));
        DailyTask task3 = new DailyTask("task3", "task3", Task.Type.WORKING,
                 LocalDateTime.of(2022,12,6,11,30));
        DailyTask task4= new DailyTask("task4", "task4", Task.Type.WORKING,
                 LocalDateTime.of(2022,12,6,11,30));
        TasksMap tasksMap = new TasksMap();
        tasksMap.addTask(task1);
        tasksMap.addTask(task2);
        tasksMap.addTask(task3);
        tasksMap.addTask(task4);
        LocalDate dayForTasks = LocalDate.of(2022, 11, 6);
        printTaskForDay(dayForTasks, tasksMap.getTasksForDay(dayForTasks));
        printForDelete(tasksMap.getAllTasks());
    }
    private static void printTaskForDay(LocalDate localDate, Collection<Task> tasks) {
        String dateString = localDate.format(DateTimeFormatter.ofPattern("dd.MM.yy"));
        if (tasks.size() == 0) {
            System.out.println("Нет задач на " + dateString);
        } else {
            System.out.println("Задачи на " + dateString );
            for (Task task: tasks) {
                System.out.printf("%s %s Описание: %s%n", task.getName(), task.getTaskDateTime(), task.getDescription());
            }
        }
    }
    private static void printForDelete(Collection<Task> tasks) {
        for (Task task : tasks) {
            System.out.printf("%d. %s %s%n", task.getId(), task.getName(), task.getTaskRepeat());
        }
    }
}
