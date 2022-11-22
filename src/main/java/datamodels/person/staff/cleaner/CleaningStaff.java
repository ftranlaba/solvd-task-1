package person.staff.cleaner;

import person.staff.Staff;
import java.util.Objects;
public abstract class CleaningStaff extends Staff{
    private String tool;

    public CleaningStaff() {
        super();
        this.tool = "";
    }

    public CleaningStaff(String firstName, String lastName, double salary, int hours, String tool) {
        super(firstName, lastName, salary, hours);
        this.tool = tool;
    }

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "CleaningStaff{" +
                "tool='" + tool + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        CleaningStaff that = (CleaningStaff) object;
        return tool.equals(that.tool);
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tool);
    }
}