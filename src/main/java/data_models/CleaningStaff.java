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
}