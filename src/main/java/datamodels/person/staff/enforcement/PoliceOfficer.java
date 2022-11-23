package person.staff.enforcement;

import java.util.Objects;

public class PoliceOfficer extends EnforcementStaff {
    private String badgeId;
    private String weapon;

    public PoliceOfficer() {
        super();
        this.badgeId = "";
    }

    public PoliceOfficer(String firstName, String lastName, double salary, int hours, String car, String badgeId, String weapon) {
        super(firstName, lastName, salary, hours, car);
        this.badgeId = badgeId;
        this.weapon = weapon;
    }

    @Override
    public void doWork() {
        System.out.println(this.getFirstName() + " " + this.getLastName() + " is patrolling campus");
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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        PoliceOfficer that = (PoliceOfficer) object;
        return badgeId.equals(that.badgeId) && weapon.equals(that.weapon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), badgeId, weapon);
    }
}