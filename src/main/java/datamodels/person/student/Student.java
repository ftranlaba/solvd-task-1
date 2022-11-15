package person.student;

import java.util.Set;
import java.util.HashSet;

import person.Person;

public abstract class Student extends Person {
    private String studentId;
    private Set<String> schedule;

    public Student() {
        super();
        this.studentId = "";
        schedule = new HashSet<>();
    }

    public Student(String firstName, String lastName, String studentId) {
        super(firstName, lastName);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Set<String> getSchedule() {
        return schedule;
    }

    public void setSchedule(Set<String> schedule) {
        this.schedule = schedule;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                '}';
    }
}