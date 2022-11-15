public class ParkingEnforcementOfficer extends EnforcementStaff{
    private int totalTicketsGivenOut;

    public ParkingEnforcementOfficer() {
        super();
        totalTicketsGivenOut = 0;
    }
    @Override
    public void doWork(){
        System.out.println("Parking Enforcement Officer is patrolling the parking lot.");
    }

    public ParkingEnforcementOfficer(String firstName, String lastName, String car, int totalTicketsGivenOut) {
        super(firstName, lastName, car);
        this.totalTicketsGivenOut = totalTicketsGivenOut;
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
}