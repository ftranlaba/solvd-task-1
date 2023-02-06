import entity.Course;
import entity.University;
import entity.person.staff.cleaner.Custodian;
import entity.person.staff.cleaner.Gardener;
import entity.person.staff.enforcement.ParkingEnforcementOfficer;
import entity.person.staff.enforcement.PoliceOfficer;
import entity.person.staff.faculty.Professor;
import entity.person.student.GraduateStudent;
import entity.person.student.UndergraduateStudent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReflectionTest {
    private static final Logger LOGGER = LogManager.getLogger("TESTLOGGER");

    public final static void main(String[] args) {
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
                    LOGGER.info("Class name: " + obj.getName());
                    LOGGER.info("Fields:");
                    Arrays.stream(obj.getDeclaredFields())
                            .forEach(fieldObj -> {
                                LOGGER.info(fieldObj.toString());
                            });
                    LOGGER.info("Constructors:");
                    Arrays.stream(obj.getConstructors())
                            .forEach(constructObj -> {
                                LOGGER.info(constructObj.toString());
                            });
                    LOGGER.info("Methods:");
                    Arrays.stream(obj.getMethods())
                            .forEach((methodObj) -> {
                                String methodHeader = Modifier.toString(methodObj.getModifiers()) + " " + methodObj.getReturnType() + " " + methodObj.getName();
                                String s = "(";
                                for (Parameter param : methodObj.getParameters()) {
                                    s += param.toString() + ",";
                                }
                                s += ")";
                                LOGGER.info(methodHeader + s);
                            });
                });
    }
}
