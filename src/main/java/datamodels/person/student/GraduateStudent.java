package person.student;
import java.util.Objects;
import java.util.Set;

import entity.Course;
public class GraduateStudent extends Student{
    private int researchPaperAmount;

    public GraduateStudent() {
        super();
        this.researchPaperAmount = 0;
    }
    @Override
    public void doWork(){
        System.out.println(this.getFirstName() + " " + this.getLastName() + " is studying for 30 hours");
    }

    public GraduateStudent(String firstName, String lastName, String studentId, Set<Course> schedule, int researchPaperAmount) {
        super(firstName, lastName, studentId, schedule);
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