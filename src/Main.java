import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TasksMap tasksMap = new TasksMap();
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner, tasksMap);
                            break;
                        case 2:
                            deleteTask(scanner, tasksMap);
                            break;
                        case 3:
                            taskOfDay(scanner, tasksMap);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
        System.out.println(tasksMap);
    }

    private static void inputTask(Scanner scanner, TasksMap tasksMap) {
        System.out.print("Введите название задачи: ");
        String taskName = scanner.useDelimiter("\n").next();
        System.out.print("Введите описание задачи: ");
        String taskDescription = scanner.useDelimiter("\n").next();
        System.out.print("Введите тип задачи: ");
        String taskType = scanner.useDelimiter("\n").next();
        System.out.print("Введите дату задачи: ");
        scanner.useDelimiter("\n").next();
        LocalDateTime localDateTime = LocalDate.parse("dd-MM-yyyy").atTime(12, 10);
        tasksMap.addTask(changeRepeat(scanner, taskName, taskDescription, taskType, localDateTime));
    }

    public static Task changeRepeat(Scanner scanner, String taskName, String taskDescription, String taskType, LocalDateTime localDateTime) {
        System.out.println("Введите тип повтора задачи: ");
        System.out.println("1 - однократная");
        System.out.println("2 - ежедневная");
        System.out.println("3 - еженедельная");
        System.out.println("4 - ежемесячная");
        System.out.println("5 - ежегодная");
        int typeSet = scanner.nextInt();
        switch (typeSet) {
            case 1:
                new SingleTask(taskName, taskDescription, taskType, localDateTime);
                break;
            case 2:
                new DailyTask(taskName, taskDescription, taskType, localDateTime);
                break;
            case 3:
                new WeeklyTask(taskName, taskDescription, taskType, localDateTime);
                break;
            case 4:
                new MounthlyTask(taskName, taskDescription, taskType, localDateTime);
                break;
            case 5:
                new AnnualTask(taskName, taskDescription, taskType, localDateTime);
                break;
        }
        return null;
    }


    private static void deleteTask(Scanner scanner, TasksMap tasksMap) {
        System.out.print("Введите id задачи: ");
        tasksMap.getRemoveTask(scanner.nextInt());
        tasksMap.removeTask(scanner.nextInt());
    }

    private static void taskOfDay(Scanner scanner, TasksMap tasksMap) {
        System.out.println("Введите дату: ");
        tasksMap.getTasksForDay(LocalDate.parse("dd.MM.yy"));
    }

    private static void printMenu() {
        System.out.println("""
                1. Добавить задачу
                2. Удалить задачу
                3. Получить задачу на указанный день
                0. Выход
                """);
    }

}