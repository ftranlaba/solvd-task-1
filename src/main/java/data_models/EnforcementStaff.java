public abstract class EnforcementStaff extends Staff{
    private String car;

    public EnforcementStaff() {
        super();
        this.car = "";
    }

    public EnforcementStaff(String firstName, String lastName, double salary, int hours, String car) {
        super(firstName, lastName, salary, hours);
        this.car = car;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "EnforcementStaff{" +
                "car='" + car + '\'' +
                '}';
    }
}