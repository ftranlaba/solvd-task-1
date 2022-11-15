public class PoliceOfficer extends EnforcementStaff{
    private String badgeId;
    private String weapon;

    public PoliceOfficer() {
        super();
        this.badgeId = "";
    }
    @Override
    public void doWork(){
        System.out.println("Police officer is patrolling campus");
    }

    public PoliceOfficer(String firstName, String lastName, String car, String badgeId) {
        super(firstName, lastName, car);
        this.badgeId = badgeId;
    }

    public String getBadgeId() {
        return badgeId;
    }

    public void setBadgeId(String badgeId) {
        this.badgeId = badgeId;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "PoliceOfficer{" +
                "badgeId='" + badgeId + '\'' +
                ", weapon='" + weapon + '\'' +
                '}';
    }
}