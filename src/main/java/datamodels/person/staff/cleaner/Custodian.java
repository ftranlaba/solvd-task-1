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
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Custodian custodian = (Custodian) object;
        return totalFacilitiesCleaned == custodian.totalFacilitiesCleaned;
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalFacilitiesCleaned);
    }
}