public class Task {

    private String title;
    private String category;
    private boolean done;   // whether the task is finished or not

    // Constructor – creates a task
    public Task(String title, String category, boolean done) {
        this.title = title;
        this.category = category;
        this.done = done;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    // Convert Task to one line for saving in the file
    public String toFileString() {
        // Example: Buy milk|Personal|false
        return title + "|" + category + "|" + done;
    }

    // Create Task from one line read from the file
    public static Task fromFileString(String line) {
        String[] parts = line.split("\\|");
        if (parts.length != 3) {
            return null;   // bad line, ignore
        }
        String title = parts[0];
        String category = parts[1];
        boolean done = Boolean.parseBoolean(parts[2]);
        return new Task(title, category, done);
    }

    @Override
    public String toString() {
        // How the task is printed in the list
        return title + " (" + category + ")" + (done ? " [done]" : "");
    }
}
