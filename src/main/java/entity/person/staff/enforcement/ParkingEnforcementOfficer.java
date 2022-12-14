package entity.person.staff.enforcement;

import java.util.Objects;

public class ParkingEnforcementOfficer extends EnforcementStaff {
    private int totalTicketsGivenOut;

    public ParkingEnforcementOfficer() {
        super();
        totalTicketsGivenOut = 0;
    }

    public ParkingEnforcementOfficer(String firstName, String lastName, double salary, int hours, String car, int totalTicketsGivenOut) {
        super(firstName, lastName, salary, hours, car);
        this.totalTicketsGivenOut = totalTicketsGivenOut;
    }

    @Override
    public void doWork() {
        LOGGER.info(this.getFirstName() + " " + this.getLastName() + " is patrolling the parking lot.");
    }

    public int getTotalTicketsGivenOut() {
        return totalTicketsGivenOut;
    }

    public void setTotalTicketsGivenOut(int totalTicketsGivenOut) {
        this.totalTicketsGivenOut = totalTicketsGivenOut;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "ParkingEnforcementOfficer{" +
                "totalTicketsGivenOut=" + totalTicketsGivenOut +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ParkingEnforcementOfficer that = (ParkingEnforcementOfficer) object;
        return totalTicketsGivenOut == that.totalTicketsGivenOut;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalTicketsGivenOut);
    }
}