package person.staff.faculty;

import person.staff.Staff;

import java.util.Objects;
import java.util.Set;

import entity.Course;

public abstract class FacultyStaff extends Staff {
    private String bookUsed;
    private Set<Course> schedule;

    public FacultyStaff() {
        super();
        this.bookUsed = "";
    }

    public FacultyStaff(String firstName, String lastName, double salary, int hours, String bookUsed) {
        super(firstName, lastName, salary, hours);
        this.bookUsed = bookUsed;
    }

    public String getBookUsed() {
        return bookUsed;
    }

    public void setBookUsed(String bookUsed) {
        this.bookUsed = bookUsed;
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
        FacultyStaff that = (FacultyStaff) object;
        return bookUsed.equals(that.bookUsed) && schedule.equals(that.schedule);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), bookUsed, schedule);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "FacultyStaff{" +
                "bookUsed='" + bookUsed + '\'' +
                ", schedule=" + schedule +
                '}';
    }
}