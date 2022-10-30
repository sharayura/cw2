import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                UserMenu.printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            UserMenu.inputTask(scanner);
                            break;
                        case 2:
                            UserMenu.removeTask(scanner);
                            break;
                        case 3:
                            UserMenu.findTask(scanner);
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
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

}