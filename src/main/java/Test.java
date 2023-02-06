import datastructure.MyLinkedList;
import entity.Course;
import entity.University;
import entity.person.Person;
import entity.person.staff.cleaner.Custodian;
import entity.person.staff.cleaner.Gardener;
import entity.person.staff.enforcement.ParkingEnforcementOfficer;
import entity.person.staff.enforcement.PoliceOfficer;
import entity.person.staff.faculty.FacultyStaff;
import entity.person.staff.faculty.Professor;
import entity.person.student.GraduateStudent;
import entity.person.student.Student;
import entity.person.student.UndergraduateStudent;
import enums.*;
import exception.InvalidMenuOptionException;
import exception.userinput.InvalidSelectCourseIntegerException;
import exception.userinput.InvalidSelectPersonIntegerException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalTime;
import java.util.*;


public final class Test {

    final static Level STATICLOG = Level.forName("STATICLOG", 699);
    final static Level MENULOG = Level.forName("MENULOG", 700);
    private static final Logger LOGGER = LogManager.getLogger("TESTLOGGER");
    private static boolean dataLoaded = false;
    private static int personMapIndex = 0;

    static {
        LOGGER.log(STATICLOG, "Example usage of static block here.");
    }

    public final static void main(String[] args) throws InvalidSelectPersonIntegerException, InvalidSelectCourseIntegerException {
        Scanner scan = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
        Stack<Person> personStack = new Stack<>();
        Map<Integer, Person> personMap = new HashMap<>();
        University uni = new University("CSULB", 1967, personList, new HashSet<>());
        infiniteloop:
        while (true) {
            LOGGER.log(MENULOG, "University Interaction Terminal Menu");
            if (personList.size() == 0) {
                LOGGER.log(MENULOG, "No one is attending this university.");
            } else {
                for (Person o : uni.getPersonList()) {
                    LOGGER.log(MENULOG, o.getFirstName() + " " + o.getLastName() + " - " + o.getClass().getSimpleName());
                }
            }
            LOGGER.log(MENULOG, "0) Load default data");
            LOGGER.log(MENULOG, "1) Create Person object");
            LOGGER.log(MENULOG, "2) Modify Person object");
            LOGGER.log(MENULOG, "3) Delete Person object");
            LOGGER.log(MENULOG, "4) Create course object");
            LOGGER.log(MENULOG, "5) View current course information");
            LOGGER.log(MENULOG, "6) View class level of every student");
            LOGGER.log(MENULOG, "7) View parking lot fees");
            LOGGER.log(MENULOG, "8) View allowed exam materials");
            LOGGER.log(MENULOG, "9) View algorithms and their O(n)");
            LOGGER.log(MENULOG, "10) Test doWork() on every Person object");
            LOGGER.log(MENULOG, "11) View students and professor schedule");
            LOGGER.log(MENULOG, "12) View newest deleted Person");
            LOGGER.log(MENULOG, "13) View oldest deleted Person");
            LOGGER.log(MENULOG, "14) Exit program");
            String input = scan.nextLine();
            switch (input) {
                case "0":
                    if (!dataLoaded) {
                        Seeder.seedDefaultData(uni);
                        dataLoaded = true;
                    } else {
                        LOGGER.log(MENULOG, "Default data is already loaded.");
                    }
                    break;
                case "1":
                    createPerson(uni, scan);
                    break;
                case "2":
                    modifyPerson(uni, scan);
                    break;
                case "3":
                    deletePerson(uni, scan, personStack, personMap);
                    break;
                case "4":
                    createCourse(uni, scan);
                    break;
                case "5":
                    viewCourseInfo(uni);
                    break;
                case "6":
                    viewStudentLevels(uni);
                    break;
                case "7":
                    viewParkingFees();
                    break;
                case "8":
                    viewAllowedExamMaterials();
                    break;
                case "9":
                    viewAlgorithms();
                    break;
                case "10":
                    testPerson(uni);
                    break;
                case "11":
                    viewSchedule(uni);
                    break;
                case "12":
                    LOGGER.log(MENULOG, personStack.peek() + "");
                    break;
                case "13":
                    LOGGER.log(MENULOG, personMap.get(personMapIndex) + "");
                    break;
                case "14":
                    break infiniteloop;
                default:
                    LOGGER.warn("User has inputted an invalid main menu option");
                    throw new InvalidMenuOptionException("User has inputted an invalid main menu option");
            }
        }
        scan.close();
        LOGGER.debug("Exited successfully");

    }

    public final static void viewStudentLevels(University o) {
        if (o.getPersonList().size() == 0) {
            LOGGER.log(MENULOG, "There are no students");
            return;
        }
        for (Person p : o.getPersonList()) {
            if (p instanceof Student) {
                LOGGER.log(MENULOG, p.getFirstName() + " " + p.getLastName() + " - " + p.getClass().getSimpleName() + " " + ((Student) p).getLevel());
            }
        }
    }

    public final static void viewParkingFees() {
        LOGGER.log(MENULOG, "Here are the parking fees");
        for (ParkingLots o : ParkingLots.values()) {
            LOGGER.log(MENULOG, o + " $" + o.getFee());
        }
    }

    public final static void viewAllowedExamMaterials() {
        LOGGER.log(MENULOG, "Here are the allowed Exam Materials");
        for (AllowedMaterials o : AllowedMaterials.values()) {
            LOGGER.log(MENULOG, o + " " + o.isAllowed());
        }
    }

    public final static void viewAlgorithms() {
        LOGGER.log(MENULOG, "Here are some algorithms and their O(n)");
        for (Algorithms o : Algorithms.values()) {
            LOGGER.log(MENULOG, o + " " + o.getRunTime());
        }
    }

    public final static void createPerson(University o, Scanner scan) {
        LOGGER.log(MENULOG, "Input first name:");
        String firstName = scan.nextLine();
        LOGGER.log(MENULOG, "Input last name:");
        String lastName = scan.nextLine();
        LOGGER.log(MENULOG, "Would you like to polymorph this Person? Y/N");
        while (true) {
            String input = scan.nextLine();
            if (input.equals("Y") || input.equals("y")) {
                LOGGER.log(MENULOG, "1) Custodian");
                LOGGER.log(MENULOG, "2) Gardener");
                LOGGER.log(MENULOG, "3) Police Officer");
                LOGGER.log(MENULOG, "4) Parking Enforcement Officer");
                LOGGER.log(MENULOG, "5) Professor");
                LOGGER.log(MENULOG, "6) Undergraduate Student");
                LOGGER.log(MENULOG, "7) Graduate Student");
                infiniteloop:
                while (true) {
                    String input2 = scan.nextLine();
                    switch (input2) {
                        case "1":
                            o.getPersonList().add(new Custodian(firstName, lastName, 10, 10, "mop", 0));
                            break infiniteloop;
                        case "2":
                            o.getPersonList().add(new Gardener(firstName, lastName, 10, 10, "mop", 0));
                            break infiniteloop;
                        case "3":
                            o.getPersonList().add(new PoliceOfficer(firstName, lastName, 10, 10, "Dodge Charger", "POC123", "Pistol"));
                            break infiniteloop;
                        case "4":
                            o.getPersonList().add(new ParkingEnforcementOfficer(firstName, lastName, 10, 10, "Dodge Charger", 0));
                            break infiniteloop;
                        case "5":
                            o.getPersonList().add(new Professor(firstName, lastName, 10, 10, "textbook", "someVar"));
                            break infiniteloop;
                        case "6":
                            o.getPersonList().add(new UndergraduateStudent(firstName, lastName, "1640298", new HashSet<>(), 0, ClassLevels.FRESHMAN));
                            break infiniteloop;
                        case "7":
                            o.getPersonList().add(new GraduateStudent(firstName, lastName, "1640298", new HashSet<>(), 0, ClassLevels.FRESHMAN));
                            break infiniteloop;
                        default:
                            LOGGER.warn("User has inputted a bad polymorph menu option");
                    }
                }
                break;
            } else if (input.equals("N") || input.equals("n")) {
                o.getPersonList().add(new UndergraduateStudent(firstName, lastName, "1640298", new HashSet<>(), 0, ClassLevels.FRESHMAN));
                break;
            } else {
                LOGGER.log(MENULOG, "Please select y/n");
            }
        }
        LOGGER.debug(firstName + " " + lastName + " was successfully created!");
    }

    public final static void modifyPerson(University o, Scanner scan) throws InvalidSelectPersonIntegerException {
        for (int i = 0; i < o.getPersonList().size(); i++) {
            Person p = o.getPersonList().get(i);
            LOGGER.log(MENULOG, i + ") " + p.getFirstName() + " " + p.getLastName() + " - " + p.getClass().getSimpleName());
        }
        LOGGER.log(MENULOG, "Who would you like to modify?");
        infiniteloop:
        while (true) {
            String input = scan.nextLine();
            try {
                int index = Integer.parseInt(input);
                if (index >= 0 && index < o.getPersonList().size()) {
                    Person p = o.getPersonList().get(index);
                    LOGGER.log(MENULOG, "What would you like to modify?");
                    LOGGER.log(MENULOG, "0) First Name");
                    LOGGER.log(MENULOG, "1) Last Name");
                    LOGGER.log(MENULOG, "2) Course (if student or professor)");
                    input = scan.nextLine();
                    switch (input) {
                        case "0":
                            LOGGER.log(MENULOG, "Enter First Name: ");
                            String firstName = scan.nextLine();
                            p.setFirstName(firstName);
                            break infiniteloop;
                        case "1":
                            LOGGER.log(MENULOG, "Enter Last Name: ");
                            String lastName = scan.nextLine();
                            p.setLastName(lastName);
                            break infiniteloop;
                        case "2":
                            if (p instanceof Student || p instanceof FacultyStaff) {
                                LOGGER.log(MENULOG, "These are all of the courses offered by the University");
                                for (Course c : o.getCourseSet()) {
                                    LOGGER.log(MENULOG, c);
                                }
                                Set<Course> diff = new HashSet<>();
                                if (p instanceof Student) {
                                    LOGGER.log(MENULOG, "These are all of the courses that the student is enrolled in");
                                    for (Course c : ((Student) p).getSchedule()) {
                                        LOGGER.log(MENULOG, c);
                                    }
                                    diff = findCourseSetDifference(((Student) p).getSchedule(), o.getCourseSet());

                                } else if (p instanceof FacultyStaff) {
                                    LOGGER.log(MENULOG, "These are all of the courses that the professor is enrolled in");
                                    for (Course c : ((FacultyStaff) p).getSchedule()) {
                                        LOGGER.log(MENULOG, c);
                                    }
                                    diff = findCourseSetDifference(((FacultyStaff) p).getSchedule(), o.getCourseSet());
                                }
                                if (diff.isEmpty()) {
                                    LOGGER.log(MENULOG, "The Person has already enrolled into all of the courses!");
                                } else {
                                    LOGGER.log(MENULOG, "Which course would you like this Person to enroll in?");
                                    Course[] arr = diff.toArray(new Course[diff.size()]);
                                    for (int i = 0; i < arr.length; i++) {
                                        LOGGER.log(MENULOG, i + ") " + arr[i]);
                                    }
                                    try {
                                        input = scan.nextLine();
                                        int num = Integer.parseInt(input);
                                        if (p instanceof Student) {
                                            ((Student) p).getSchedule().add(arr[num]);
                                        } else if (p instanceof FacultyStaff) {
                                            ((FacultyStaff) p).getSchedule().add(arr[num]);
                                        }
                                    } catch (Exception e) {
                                        LOGGER.error("User has inputted an invalid integer when selecting a course");
                                        throw new InvalidSelectCourseIntegerException("User has inputted an invalid integer when selecting a course", e);
                                    }
                                }
                            } else {
                                LOGGER.log(MENULOG, "This Person is not a student or professor");
                            }
                            break infiniteloop;

                    }
                }
            } catch (Exception e) {
                LOGGER.error("User has inputted an invalid integer when selecting a person during modification");
                throw new InvalidSelectPersonIntegerException("User has inputted an invalid integer when selecting a person during modification", e);
            }
        }
        LOGGER.debug("Successfully modified!");
    }

    public final static Set<Course> findCourseSetDifference(Set<Course> o1, Set<Course> o2) {
        Set<Course> output = new HashSet<>();
        for (Course c : o1) {
            if (!o2.contains(c)) {
                output.add(c);
            }
        }
        for (Course c : o2) {
            if (!o1.contains(c)) {
                output.add(c);
            }
        }
        return output;
    }

    // LinkedList would perform better than ArrayList here
    public final static void deletePerson(University o, Scanner scan, Stack<Person> personStack, Map<Integer, Person> personMap) throws InvalidSelectPersonIntegerException {
        for (int i = 0; i < o.getPersonList().size(); i++) {
            Person p = o.getPersonList().get(i);
            LOGGER.log(MENULOG, i + ") " + p.getFirstName() + " " + p.getLastName() + " - " + p.getClass().getSimpleName());
        }
        LOGGER.log(MENULOG, "Who would you like to delete?");
        infiniteloop:
        while (true) {
            String input = scan.nextLine();
            try {
                int index = Integer.parseInt(input);
                if (index >= 0 && index < o.getPersonList().size()) {
                    personMap.put(personMapIndex, o.getPersonList().get(index));
                    personMapIndex++;
                    personStack.add(o.getPersonList().get(index));
                    o.getPersonList().remove(index);
                    break infiniteloop;
                }
            } catch (Exception e) {
                LOGGER.error("User has inputted an invalid integer when selecting a person during deletion");
                throw new InvalidSelectPersonIntegerException("User has inputted an invalid integer when selecting a person during deletion", e);
            }
        }
        LOGGER.debug("Successfully deleted!");
    }

    public final static void createCourse(University o, Scanner scan) throws InvalidSelectCourseIntegerException {
        LOGGER.log(MENULOG, "Input course title:");
        String courseTitle = scan.nextLine();
        LOGGER.log(MENULOG, "Input major:");
        String major = scan.nextLine();
        infiniteloop:
        while (true) {
            LOGGER.log(MENULOG, "Input days of the week as 7 bits. For example, 0101000 represents Mondays and Wednesdays");
            String days = scan.nextLine();
            if (Course.isDaysValid(days)) {
                try {
                    LOGGER.log(MENULOG, "At what hour of the day does this class start? Pick a number in the range [0, 23])");
                    int hours = scan.nextInt();
                    LOGGER.log(MENULOG, "At what minutes does it start? Pick a number in the range [0, 59]");
                    int minutes = scan.nextInt();
                    o.getCourseSet().add(new Course(courseTitle, major, days, LocalTime.of(hours, minutes), BuildingNumbers.B101));
                    break infiniteloop;
                } catch (Exception e) {
                    LOGGER.error("User has inputted an invalid integer when creating course");
                    throw new InvalidSelectCourseIntegerException("User has inputted an invalid integer when creating course", e);
                }
            }
            LOGGER.warn("User has inputted an invalid integer when selecting a person during deletion");
        }
        LOGGER.debug(courseTitle + " has been successfully created!");

    }

    public final static void viewCourseInfo(University o) {
        Course[] arr = o.getCourseSet().toArray(new Course[o.getCourseSet().size()]);
        if (arr.length == 0) {
            LOGGER.log(MENULOG, "There are currently no courses");
            return;
        }
        // Example usage of custom LinkedList
        MyLinkedList<String> list = new MyLinkedList<>();
        for (Course c : arr) {
            list.add(c.toString());
        }
        LOGGER.log(MENULOG, list.toString());
    }

    public final static void testPerson(University o) {
        for (Person p : o.getPersonList()) {
            p.doWork();
        }
    }

    public final static void viewSchedule(University o) {
        for (Course c : o.getCourseSet()) {
            LOGGER.log(MENULOG, c);
            boolean isEmpty = true;
            for (Person p : o.getPersonList()) {
                if (p instanceof Student) {
                    if (((Student) p).getSchedule().contains(c)) {
                        LOGGER.log(MENULOG, p.getFirstName() + " " + p.getLastName() + " - " + p.getClass().getSimpleName());
                        isEmpty = false;
                    }
                } else if (p instanceof FacultyStaff) {
                    if (((FacultyStaff) p).getSchedule().contains(c)) {
                        LOGGER.log(MENULOG, p.getFirstName() + " " + p.getLastName() + " - " + p.getClass().getSimpleName());
                        isEmpty = false;
                    }
                }
            }
            if (isEmpty) {
                LOGGER.debug("No one is taking this course.");
            }
        }
    }

}