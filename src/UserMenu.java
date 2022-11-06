import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public abstract class UserMenu {
    public static void inputTask(Scanner scanner, TaskService taskService) throws IOException {
        scanner.nextLine();                              // почему-то без этого работает некорректно
        String taskTitle = checkInputLine(scanner, "Введите заголовок задачи: ");
        String taskDescription = checkInputLine(scanner, "Введите описание задачи: ");

        boolean isInputRight = false;
        LocalDateTime taskTime = null;
        while (!isInputRight) {
            try {
                taskTime = getInputTime(scanner, true);
                isInputRight = true;
            } catch (DateTimeParseException e) {
                System.out.println("Вы ввели неправильно, попробуйте еще раз!");
            }
        }

        int input = checkInputInt(scanner, 1, 2,
                "Выберете тип задачи (1 - личная, 2 - рабочая): ");
        Task.TaskType taskType = (input == 1) ? Task.TaskType.TYPE_PRIVATE : Task.TaskType.TYPE_WORK;

        input = checkInputInt(scanner, 1, 5,
                "Выберете тип повторяемости задачи:\n" +
                        "1. однократная,\n" +
                        "2. ежедневная,\n" +
                        "3. еженедельная,\n" +
                        "4. ежемесячная,\n" +
                        "5. ежегодная\n");
        Task newTask = null;
        switch (input) {
            case 1:
                newTask = new SingleTask(taskTitle, taskDescription, taskTime, taskType);
                break;
            case 2:
                newTask = new DayTask(taskTitle, taskDescription, taskTime, taskType);
                break;
            case 3:
                newTask = new WeekTask(taskTitle, taskDescription, taskTime, taskType);
                break;
            case 4:
                newTask = new MonthTask(taskTitle, taskDescription, taskTime, taskType);
                break;
            case 5:
                newTask = new YearTask(taskTitle, taskDescription, taskTime, taskType);
        }
        taskService.addTaskToCollection(newTask);
        System.out.println("Задача id=" + newTask.getId() + ", \"" + newTask.getTitle() + "\" добавлена!");
        System.out.println();
    }

    private static int checkInputInt(Scanner scanner, int min, int max, String message) {
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                int inputInt = scanner.nextInt();
                if (inputInt >= min && inputInt <= max) {
                    return inputInt;
                }
            } else {
                scanner.next();
            }
        }
    }

    private static String checkInputLine(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            if (scanner.hasNextLine()) {
                return scanner.nextLine();
            } else {
                scanner.next();
            }
        }
    }

    public static void findTask(Scanner scanner, TaskService taskService) {
        System.out.println("Введите дату, на которую нужно найти все задачи.");
        scanner.nextLine();
        LocalDateTime findTime = getInputTime(scanner, false);
        LocalDate localDate = LocalDate.from(findTime);
        System.out.println("Задачи на " + localDate + ":");
        for (Task task : taskService.tasksByTime(localDate)) {
            System.out.println("id=" + task.getId() + " \"" + task.getTitle() + "\"");
        }
        System.out.println();
    }

    public static void removeTask(Scanner scanner, TaskService taskService) {
        int collectionSize = taskService.getCollectionSize();
        if (collectionSize == 0) {
            System.out.println("Не добавлено ни одной задачи!");
            System.out.println();
            return;
        }
        int id = checkInputInt(scanner, 0, collectionSize - 1,
                "Напишите id задачи, которую нужно удалить: ");
        taskService.removeTaskFromCollection(id);
        System.out.println("Задача id=" + id + " удалена!");
        System.out.println();
    }

    private static LocalDateTime getInputTime(Scanner scanner, boolean hasHoursAndMinutes) {
        String dateTimeFormat = "yyyy-MM-dd HH:mm";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormat);
        String hoursMins;
        String message;
        if (hasHoursAndMinutes) {
            hoursMins = "";
            message = "Введите дату и время в формате \"yyyy-MM-dd HH:mm\": ";
        } else {
            hoursMins = " 00:00";
            message = "Введите дату в формате \"yyyy-MM-dd\": ";
        }
        String input = checkInputLine(scanner, message);
        input += hoursMins;
        LocalDateTime dateTime = LocalDateTime.parse(input, formatter);
        return dateTime;
    }

    public static void printMenu() {
        System.out.println("***** Меню ежедневника *****\n" +
                "   1. Добавить задачу\n" +
                "   2. Удалить задачу по id\n" +
                "   3. Получить задачу на указанный день\n" +
                "   0. Выход\n" +
                "***************************");

    }
}
