package javaswing.testroom;

public class Task {
    private int id;
    private String description;
    private String status;

    public Task(int id, String description) {
        setDescription(description);
        setId(id);
        this.status = "Pending";
    }

    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty.");
        }
        this.description = description;
    }

    public void setId(int id){
        if(id < 0){
            throw new IllegalArgumentException("ID must be positive number");
        }
        this.id = id;
    }

    public void markAsDone() {
        this.status = "Done";
    }

    public int getId() {
        return id;
    }

    public String getDescription(){
        return description;
    }

    public String toSummaryString() {
        return String.format("%d | %s | %s ", id, description, status);
    }
}