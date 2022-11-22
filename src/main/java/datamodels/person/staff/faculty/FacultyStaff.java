package person.staff.faculty;

import person.staff.Staff;
import java.util.Objects;
public abstract class FacultyStaff extends Staff{
    private String bookUsed;

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

    @java.lang.Override
    public java.lang.String toString() {
        return "FacultyStaff{" +
                "bookUsed='" + bookUsed + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        FacultyStaff that = (FacultyStaff) object;
        return bookUsed.equals(that.bookUsed);
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bookUsed);
    }
}