import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TodoApp app = new TodoApp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== TODO LIST APP =====");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. List Tasks");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number between 1 and 4.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter category (Work / Personal / Study etc.): ");
                    String category = scanner.nextLine();

                    app.addTask(title, category);
                    break;

                case 2:
                    app.listTasks();
                    System.out.print("Enter task number to remove: ");
                    try {
                        int num = Integer.parseInt(scanner.nextLine());
                        app.removeTask(num - 1);   // convert 1-based to 0-based index
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                    }
                    break;

                case 3:
                    app.listTasks();
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
