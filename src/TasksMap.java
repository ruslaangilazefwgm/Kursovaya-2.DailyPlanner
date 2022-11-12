import java.time.LocalDate;
import java.util.*;

public class TasksMap {
    private final Map<Integer, Task> tasksMap = new HashMap<>();

    public  void addTask(Task task) {
        this.tasksMap.put(task.getId(), task);
    }

    public void removeTask(int id) {
        if (!tasksMap.containsKey(id)) {
            throw new RuntimeException("Нет такой задачи");
        }
        tasksMap.remove(id);
    }

    public Collection<Task> getTasksForDay(LocalDate localDate) {
        Set<Task> taskForDay = new TreeSet<>(new TaskTimeComparator());
        for (Task task : tasksMap.values()) {
            if (task.appearsIn(localDate)) {
                taskForDay.add(task);
            }
        }
        return taskForDay;
    }

    public Collection<Task> getAllTasks() {
        return tasksMap.values();
    }

    public Task getRemoveTask(int id) {
        if (tasksMap.containsKey(id)) {
            return tasksMap.get(id);
        }
        return null;
    }


    @Override
    public String toString() {
        return "tasksMap= " + tasksMap;
    }
}
