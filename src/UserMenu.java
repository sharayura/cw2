import java.io.IOException;
import java.util.Scanner;

public abstract class UserMenu {
    public static void inputTask(Scanner scanner) throws IOException {
        System.out.print("Введите заголовок задачи: ");
        String taskName = scanner.next();
        System.out.print("Введите описание задачи: ");
        String taskDescription = scanner.next();
        System.out.println("Выберете тип задачи (1 - личная, 2 - рабочая):");
        Task.TaskType taskType;
        if (scanner.hasNextInt()) {
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    taskType = Task.TaskType.TYPE_PRIVATE;
                    break;
                case 2:
                    taskType = Task.TaskType.TYPE_WORK;
                    break;
                default:
                    System.out.println("Такого пункта нет, выбран тип \"рабочая\"");
                    taskType = Task.TaskType.TYPE_PRIVATE;
            }
        } else {
            System.out.println("Неправильный ввод!");
            scanner.next();
            return;
        }


    }

    public static void printMenu() {
        System.out.println("***** Меню ежедневника *****\n   1. Добавить задачу\n   2. Удалить задачу\n" +
                "   3. Получить задачу на указанный день\n   0. Выход\n**********");

    }
}
