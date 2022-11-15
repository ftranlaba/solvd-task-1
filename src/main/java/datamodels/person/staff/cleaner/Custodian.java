package person.staff.cleaner;
public class Custodian extends CleaningStaff{
    private int totalFacilitiesCleaned;

    public Custodian(){
        super();
        totalFacilitiesCleaned = 0;
    }
    @Override
    public void doWork(){
        System.out.println("Custodian is cleaning the classroom");
    }

    public Custodian(String firstName, String lastName, double salary, int hours, String tool, int totalFacilitiesCleaned) {
        super(firstName, lastName, salary, hours, tool);
        this.totalFacilitiesCleaned = totalFacilitiesCleaned;
    }

    public int getTotalFacilitiesCleaned() {
        return totalFacilitiesCleaned;
    }

    public void setTotalFacilitiesCleaned(int totalFacilitiesCleaned) {
        this.totalFacilitiesCleaned = totalFacilitiesCleaned;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Custodian{" +
                "totalFacilitiesCleaned=" + totalFacilitiesCleaned +
                '}';
    }
}