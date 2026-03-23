package javaswing.testroom;

import java.util.*;

public class StudentRepository {

    // List of Student objects
    private final List<Student> students = new ArrayList<>();

    public void add(Student student) {
        // validate the object
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null.");
        }
        students.add(student);
    }

    public List<Student> findAll() {
        return students;
    }

    public Student findById(String id) {
        if (id == null) {
            return null;
        }

        for(Student s : students){
            if(id.equals(s.getStudentId())){
                return s;
            }
        }
        return null;
    }
    public boolean delete(Student student){
        if(student == null){
            return false;
        }
        return students.remove(student);
    }
}
