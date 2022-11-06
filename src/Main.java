import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        Scanner scanner = new Scanner(System.in);
        label:
        while (true) {
            UserMenu.printMenu();
            System.out.print("Выберите пункт меню: ");
            if (scanner.hasNextInt()) {
                int menu = scanner.nextInt();
                switch (menu) {
                    case 1:
                        boolean isInputRight = false;
                        while (!isInputRight) {
                            try {
                                UserMenu.inputTask(scanner, taskService);
                                isInputRight = true;
                            } catch (IOException e) {
                                System.out.println(e.getMessage() + " Попробуйте еще раз!");
                            }
                        }
                        break;
                    case 2:
                        UserMenu.removeTask(scanner, taskService);
                        break;
                    case 3:
                        UserMenu.findTask(scanner, taskService);
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

}