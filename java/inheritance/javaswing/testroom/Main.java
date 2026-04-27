package inheritance.javaswing.testroom;

public class Main {
    public static void main(String[] args) {

        TaskManager manager = new TaskManager();
        manager.addTask(new Task(1, "Buy groceries"));
        manager.addTask(new Task(2, "Finish homework"));
        manager.addTask(new Task(3, "Clean room"));


        // Print all tasks
        System.out.println("--- All Tasks ---");
        for (Task t : manager.getAllTasks()) {
            System.out.println(t.toSummaryString());
        }

        // Mark task 2 as done
        manager.markTaskDone(2);

        // Print all tasks again
        System.out.println("\n--- After Marking Task 2 as Done ---");
        for (Task t : manager.getAllTasks()) {
            System.out.println(t.toSummaryString());
        }

        // Remove task 1
        manager.removeTask(1);

        // Print all tasks again
        System.out.println("\n--- After Removing Task 1 ---");
        for (Task t : manager.getAllTasks()) {
            System.out.println(t.toSummaryString());
        }
    }
}
