package javaswing.testroom;

public class Student {
    private String studentID;
    private String name;
    private String status;

    Student(String id, String name, String status) {
        setStudentId(id);
        setName(name);
        setStatus(status);
    }

    public void setStudentId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID cannot be null or blank.");
        }
        this.studentID = id;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank.");
        }
        this.name = name;
    }

    public void setStatus(String status) {
        if (!(status == "Active" || status == "Inactive")) {
            throw new IllegalArgumentException("Invalid status.");
        }
        this.status = status;
    }
    public String getStudentId(){
        return studentID;
    }
    public String getName(){
        return name;
    }
    public String getStatus(){
        return status;
    }

    public String toSummaryString() {
        return String.format("%s | %s | %s", studentID, name, status);
    }
}
