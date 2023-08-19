import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        while (true) {
            System.out.println("1. Add task");
            System.out.println("2. List tasks");
            System.out.println("3. Remove task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    Task task = new Task(description);
                    taskManager.addTask(task);
                    System.out.println("Task added successfully.");
                    break;
                case 2:
                    System.out.println("Tasks:");
                    List<Task> tasks = taskManager.getTasks();
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i).getDescription());
                    }
                    break;
                case 3:
                    System.out.print("Enter task index to remove: ");
                    int index = scanner.nextInt();
                    taskManager.removeTask(index - 1);
                    System.out.println("Task removed.");
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
