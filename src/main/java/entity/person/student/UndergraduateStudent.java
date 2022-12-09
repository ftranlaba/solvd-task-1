package entity.person.student;

import entity.Course;
import enums.ClassLevels;

import java.util.Objects;
import java.util.Set;

public class UndergraduateStudent extends Student {
    private int internshipAmount;

    public UndergraduateStudent() {
        super();
        this.internshipAmount = 0;
    }

    public UndergraduateStudent(String firstName, String lastName, String studentId, Set<Course> schedule, int internshipAmount, ClassLevels level) {
        super(firstName, lastName, studentId, schedule, level);
        this.internshipAmount = internshipAmount;
    }

    @Override
    public void doWork() {
        LOGGER.info(this.getFirstName() + " " + this.getLastName() + " is studying for 20 hours");
    }

    public int getInternshipAmount() {
        return internshipAmount;
    }

    public void setInternshipAmount(int internshipAmount) {
        this.internshipAmount = internshipAmount;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "UndergraduateStudent{" +
                "internshipAmount=" + internshipAmount +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        UndergraduateStudent that = (UndergraduateStudent) object;
        return internshipAmount == that.internshipAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), internshipAmount);
    }
}