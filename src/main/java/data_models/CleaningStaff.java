public abstract class CleaningStaff extends Staff{
    private String tool;

    public CleaningStaff() {
        super();
        this.tool = "";
    }

    public CleaningStaff(double salary, int hours, String tool) {
        super(salary, hours);
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