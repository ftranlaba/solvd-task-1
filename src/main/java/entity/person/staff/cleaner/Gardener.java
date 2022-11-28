package entity.person.staff.cleaner;

import java.util.Objects;

public class Gardener extends CleaningStaff {
    private int totalFlowersTended;

    public Gardener() {
        super();
        this.totalFlowersTended = 0;
    }

    public Gardener(String firstName, String lastName, double salary, int hours, String tool, int totalFlowersTended) {
        super(firstName, lastName, salary, hours, tool);
        this.totalFlowersTended = totalFlowersTended;
    }

    @Override
    public void doWork() {
        System.out.println(this.getFirstName() + " " + this.getLastName() + " is tending to flowers");
    }

    public int getTotalFlowersTended() {
        return totalFlowersTended;
    }

    public void setTotalFlowersTended(int totalFlowersTended) {
        this.totalFlowersTended = totalFlowersTended;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Gardener{" +
                "totalFlowersTended=" + totalFlowersTended +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Gardener gardener = (Gardener) object;
        return totalFlowersTended == gardener.totalFlowersTended;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalFlowersTended);
    }
}