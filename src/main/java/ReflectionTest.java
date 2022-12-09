import entity.Course;
import entity.University;
import entity.person.staff.cleaner.Custodian;
import entity.person.staff.cleaner.Gardener;
import entity.person.staff.enforcement.ParkingEnforcementOfficer;
import entity.person.staff.enforcement.PoliceOfficer;
import entity.person.staff.faculty.Professor;
import entity.person.student.GraduateStudent;
import entity.person.student.UndergraduateStudent;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReflectionTest {
    public static void print(Object o) {
        System.out.println(o);
    }

    public final static void main(String[] args){
        List<Object> list = new ArrayList<>();
        list.add(new University());
        list.add(new Course());
        list.add(new GraduateStudent());
        list.add(new UndergraduateStudent());
        list.add(new Professor());
        list.add(new PoliceOfficer());
        list.add(new ParkingEnforcementOfficer());
        list.add(new Custodian());
        list.add(new Gardener());
        list.stream()
                .forEach((o) -> {
                    Class obj = o.getClass();
                    print("Class name: " + obj.getName());
                    print("Fields:");
                    Arrays.stream(obj.getDeclaredFields())
                            .forEach(fieldObj -> {
                                String fieldHeader = fieldObj.toString();
                                System.out.print("\t" + fieldHeader + "\n");
                            });
                    print("Constructors:");
                    Arrays.stream(obj.getConstructors())
                            .forEach(constructObj -> {
                                String constructHeader = constructObj.toString();
                                System.out.print("\t" + constructHeader + "\n");
                            });
                    print("Methods:");
                    Arrays.stream(obj.getMethods())
                            .forEach((methodObj) -> {
                                String methodHeader = Modifier.toString(methodObj.getModifiers()) + " " + methodObj.getReturnType() + " " + methodObj.getName();
                                System.out.print("\t" + methodHeader);
                                System.out.print("(");
                                Arrays.stream(methodObj.getParameters()).forEach(parameter -> System.out.print(parameter.toString() + ","));
                                System.out.print(")\n");
                            });
                    print("");
                });
    }
}
