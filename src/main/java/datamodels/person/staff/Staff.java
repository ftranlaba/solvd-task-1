package person.staff;

import person.Person;
import java.util.Objects;
public abstract class Staff extends Person{
    private double salary;
    private int hours;

    public Staff() {
        super();
        this.salary = 0;
        this.hours = 0;
    }

    public Staff(String firstName, String lastName, double salary, int hours) {
        super(firstName, lastName);
        this.salary = salary;
        this.hours = hours;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Staff{" +
                "salary=" + salary +
                ", hours=" + hours +
                '}';
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Staff staff = (Staff) object;
        return java.lang.Double.compare(staff.salary, salary) == 0 && hours == staff.hours;
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), salary, hours);
    }
}