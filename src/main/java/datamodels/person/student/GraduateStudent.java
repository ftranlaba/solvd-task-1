package person.student;
import java.util.Objects;
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
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        GraduateStudent that = (GraduateStudent) object;
        return researchPaperAmount == that.researchPaperAmount;
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), researchPaperAmount);
    }
}