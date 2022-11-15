public class UndergraduateStudent extends Student{
    private int internshipAmount;

    public UndergraduateStudent() {
        super();
        this.internshipAmount = 0;
    }
    @Override
    public void doWork(){
        System.out.println("Undergraduate Student is studying for 20 hours");
    }

    public UndergraduateStudent(String firstName, String lastName, String studentId, int internshipAmount) {
        super(firstName, lastName, studentId);
        this.internshipAmount = internshipAmount;
    }

    public int getInternshipAmount() {
        return internshipAmount;
    }

    public void setInternshipAmount(int internshipAmount) {
        this.internshipAmount = internshipAmount;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "UndergraduateStudent{" +
                "internshipAmount=" + internshipAmount +
                '}';
    }
}