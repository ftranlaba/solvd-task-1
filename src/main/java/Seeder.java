import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import entity.person.student.*;
import entity.Course;
import entity.University;
;

public final class Seeder {
    private Seeder() {
    }

    public static void seedDefaultData(University o) {
        o.getPersonList().addAll(Seeder.seedStudent());
        o.getCourseSet().addAll(Seeder.seedCourse());

    }

    public static List<Student> seedStudent() {
        List<Student> output = new ArrayList<>();
        output.add(new UndergraduateStudent("John", "Smith", "1640298", new HashSet<>(), 0));
        output.add(new UndergraduateStudent("Adam", "Smith", "2440298", new HashSet<>(), 0));
        output.add(new UndergraduateStudent("Ricky", "Smith", "8840298", new HashSet<>(), 0));
        output.add(new UndergraduateStudent("Kevin", "Smith", "9940298", new HashSet<>(), 0));
        output.add(new GraduateStudent("Deodat", "Smith", "1140298", new HashSet<>(), 0));
        output.add(new GraduateStudent("Chris", "Smith", "1340298", new HashSet<>(), 0));
        output.add(new GraduateStudent("Ricardo", "Smith", "1540298", new HashSet<>(), 0));

        return output;
    }

    public static Set<Course> seedCourse() {
        Set<Course> output = new HashSet<>();
        output.add(new Course("OOP", "CS", "0101000", LocalTime.of(8, 0)));
        output.add(new Course("Computer Architecture", "CS", "0010100", LocalTime.of(10, 0)));
        output.add(new Course("Algorithms", "CS", "0101010", LocalTime.of(13, 0)));

        return output;
    }
}
