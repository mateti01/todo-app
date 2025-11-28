import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TodoApp {

    private List<Task> tasks = new ArrayList<>();
    private static final String FILE_NAME = "tasks.txt";

    public TodoApp() {
        loadTasks();   // when app starts, read tasks from file (if exists)
    }

    // ---------------------------
    // LOAD TASKS FROM FILE
    // ---------------------------
    private void loadTasks() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return;   // nothing to load yet
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Task t = Task.fromFileString(line);
                if (t != null) {
                    tasks.add(t);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }

    // ---------------------------
    // SAVE TASKS TO FILE
    // ---------------------------
    private void saveTasks() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Task t : tasks) {
                writer.println(t.toFileString());
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    // ---------------------------
    // ADD NEW TASK
    // ---------------------------
    public void addTask(String title, String category) {
        tasks.add(new Task(title, category, false));  // new tasks start as not done
        saveTasks();
        System.out.println("Task added successfully!");
    }

    // ---------------------------
    // REMOVE TASK BY INDEX
    // ---------------------------
    public void removeTask(int index) {
        if (index < 0 || index >= tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }
        tasks.remove(index);
        saveTasks();
        System.out.println("Task removed.");
    }

    // ---------------------------
    // LIST ALL TASKS
    // ---------------------------
    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks yet.");
            return;
        }

        System.out.println("\nYour tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            System.out.println((i + 1) + ". " + t.toString());
        }
    }
}

