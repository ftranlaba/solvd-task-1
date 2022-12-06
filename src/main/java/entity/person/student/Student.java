package entity.person.student;

import java.util.Set;

import entity.Course;

import java.util.HashSet;

import entity.person.Person;
import enums.ClassLevels;
import enums.ParkingLots;

import java.util.Objects;

public abstract class Student extends Person {
    private String studentId;
    private Set<Course> schedule;
    private ClassLevels level;

    public Student() {
        super();
        this.studentId = "";
        schedule = new HashSet<>();
        this.level = ClassLevels.FRESHMAN;
    }

    public Student(String firstName, String lastName, String studentId, Set<Course> schedule, ClassLevels level) {
        super(firstName, lastName);
        this.studentId = studentId;
        this.schedule = schedule;
        this.level = level;
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

    public ClassLevels getLevel() {
        return level;
    }

    public void setLevel(ClassLevels level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", schedule=" + schedule +
                ", level=" + level +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return studentId.equals(student.studentId) && schedule.equals(student.schedule) && level == student.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), studentId, schedule, level);
    }
}
