package person.student;
public class GraduateStudent extends Student{
    private int researchPaperAmount;

    public GraduateStudent() {
        super();
        this.researchPaperAmount = 0;
    }
    @Override
    public void doWork(){
        System.out.println("Graduate Student is studying for 30 hours");
    }

    public GraduateStudent(String firstName, String lastName, String studentId, int researchPaperAmount) {
        super(firstName, lastName, studentId);
        this.researchPaperAmount = researchPaperAmount;
    }

    public int getResearchPaperAmount() {
        return researchPaperAmount;
    }

    public void setResearchPaperAmount(int researchPaperAmount) {
        this.researchPaperAmount = researchPaperAmount;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "GraduateStudent{" +
                "researchPaperAmount=" + researchPaperAmount +
                '}';
    }
}