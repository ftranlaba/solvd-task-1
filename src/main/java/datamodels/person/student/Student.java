package person.student;

import java.util.Set;

import entity.Course;

import java.util.HashSet;

import person.Person;
import java.util.Objects;
public abstract class Student extends Person {
    private String studentId;
    private Set<Course> schedule;

    public Student() {
        super();
        this.studentId = "";
        schedule = new HashSet<>();
    }

    public Student(String firstName, String lastName, String studentId, Set<Course> schedule) {
        super(firstName, lastName);
        this.studentId = studentId;
        this.schedule = schedule;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Set<Course> getSchedule() {
        return schedule;
    }

    public void setSchedule(Set<Course> schedule) {
        this.schedule = schedule;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Student student = (Student) object;
        return studentId.equals(student.studentId) && schedule.equals(student.schedule);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), studentId, schedule);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", schedule=" + schedule +
                '}';
    }
}
