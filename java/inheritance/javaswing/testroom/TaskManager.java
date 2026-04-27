package inheritance.javaswing.testroom;

import java.util.*;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }
        tasks.add(task);
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    public Task findTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public void markTaskDone(int id) {
        Task task = findTaskById(id);

        if (task == null) {
            throw new IllegalArgumentException("ID not found: " + id);
        }

        task.markAsDone();
    }

    public boolean removeTask(int id) {
        Iterator<Task> it = tasks.iterator();

        while(it.hasNext()){
            Task task = it.next();
            if(task.getId() == id){
                it.remove();
                return true;
            }
        }
        return false;
    }
}
