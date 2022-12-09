package entity.person.staff.faculty;

import java.util.Objects;

public class Professor extends FacultyStaff {
    private String someData;

    public Professor() {
        super();
        this.someData = "";
    }

    public Professor(String firstName, String lastName, double salary, int hours, String bookUsed, String someData) {
        super(firstName, lastName, salary, hours, bookUsed);
        this.someData = someData;
    }

    @Override
    public void doWork() {
        LOGGER.info(this.getFirstName() + " " + this.getLastName() + " is lecturing the class");
    }

    public String getSomeData() {
        return someData;
    }

    public void setSomeData(String someData) {
        this.someData = someData;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Professor{" +
                "someData='" + someData + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Professor professor = (Professor) object;
        return someData.equals(professor.someData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), someData);
    }
}