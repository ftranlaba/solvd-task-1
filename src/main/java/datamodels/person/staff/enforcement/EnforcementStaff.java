package person.staff.enforcement;

import person.staff.Staff;
import java.util.Objects;
public abstract class EnforcementStaff extends Staff{
    private String car;

    public EnforcementStaff() {
        super();
        this.car = "";
    }

    public EnforcementStaff(String firstName, String lastName, double salary, int hours, String car) {
        super(firstName, lastName, salary, hours);
        this.car = car;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "EnforcementStaff{" +
                "car='" + car + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        EnforcementStaff that = (EnforcementStaff) object;
        return car.equals(that.car);
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), car);
    }
}