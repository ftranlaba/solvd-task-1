import java.util.ArrayList;
import java.util.List;
import person.student.*;;

public final class Seeder {
    private Seeder(){}

    public static List<Student> seedStudent(){
        List<Student> output = new ArrayList<>();
        output.add(new UndergraduateStudent("John", "Smith", "1640298", 0));
        output.add(new UndergraduateStudent("Adam", "Smith", "2440298", 0));
        output.add(new UndergraduateStudent("Ricky", "Smith", "8840298", 0));
        output.add(new UndergraduateStudent("Kevin", "Smith", "9940298", 0));
        output.add(new GraduateStudent("Deodat", "Smith", "1140298", 0));
        output.add(new GraduateStudent("Chris", "Smith", "1340298", 0));
        output.add(new GraduateStudent("Ricardo", "Smith", "1540298", 0));

        return output;
    }
}
