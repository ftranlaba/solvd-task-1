public class Professor extends FacultyStaff{
    private String someData;

    public Professor() {
        super();
        this.someData = "";
    }
    @Override
    public void doWork(){
        System.out.println("Professor is lecturing the class");
    }
    public Professor(String firstName, String lastName, double salary, int hours, String bookUsed, String someData) {
        super(firstName, lastName, salary, hours, bookUsed);
        this.someData = someData;
    }

    public String getSomeData() {
        return someData;
    }

    public void setSomeData(String someData) {
        this.someData = someData;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Professor{" +
                "someData='" + someData + '\'' +
                '}';
    }
}