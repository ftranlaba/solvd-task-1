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
import exception.InvalidMenuOptionException;
import exception.userinput.InvalidSelectCourseIntegerException;
import exception.userinput.InvalidSelectPersonIntegerException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalTime;
import java.util.*;


public final class Test {

    private static boolean dataLoaded = false;
    final static Level STATICLOG = Level.forName("STATICLOG", 699);
    final static Level MENULOG = Level.forName("MENULOG", 700);
    private static Logger logger = LogManager.getLogger("TESTLOGGER");
    private static int personMapIndex = 0;

    static {
        logger.log(STATICLOG,"Example usage of static block here.");
    }

    public final static void main(String[] args) throws InvalidSelectPersonIntegerException, InvalidSelectCourseIntegerException {
        Scanner scan = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
        Stack<Person> personStack = new Stack<>();
        Map<Integer, Person> personMap = new HashMap<>();
        University uni = new University("CSULB", 1967, personList, new HashSet<>());
        infiniteloop:
        while (true) {
            logger.log(MENULOG, "University Interaction Terminal Menu");
            if (personList.size() == 0) {
                logger.log(MENULOG, "No one is attending this university.");
            } else {
                for (Person o : uni.getPersonList()) {
                    logger.log(MENULOG, o.getFirstName() + " " + o.getLastName() + " - " + o.getClass().getSimpleName());
                }
            }
            logger.log(MENULOG, "0) Load default data");
            logger.log(MENULOG, "1) Create Person object");
            logger.log(MENULOG, "2) Modify Person object");
            logger.log(MENULOG, "3) Delete Person object");
            logger.log(MENULOG, "4) Create course object");
            logger.log(MENULOG, "5) Test doWork() on every Person object");
            logger.log(MENULOG, "6) View students and professor schedule");
            logger.log(MENULOG, "7) View newest deleted Person");
            logger.log(MENULOG, "8) View oldest deleted Person");
            logger.log(MENULOG, "9) Exit program");
            String input = scan.nextLine();
            switch (input) {
                case "0":
                    if (!dataLoaded) {
                        Seeder.seedDefaultData(uni);
                        dataLoaded = true;
                    } else {
                        logger.log(MENULOG, "Default data is already loaded.");
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
                    testPerson(uni);
                    break;
                case "6":
                    viewSchedule(uni);
                    break;
                case "7":
                    logger.log(MENULOG, personStack.peek() + "");
                    break;
                case "8":
                    logger.log(MENULOG, personMap.get(personMapIndex) + "");
                    break;
                case "9":
                    break infiniteloop;
                default:
                    logger.warn("User has inputted an invalid main menu option");
                    throw new InvalidMenuOptionException("User has inputted an invalid main menu option");
            }
        }
        scan.close();
        logger.debug("Exited successfully");

    }

    public final static void createPerson(University o, Scanner scan) {
        logger.log(MENULOG, "Input first name:");
        String firstName = scan.nextLine();
        logger.log(MENULOG, "Input last name:");
        String lastName = scan.nextLine();
        logger.log(MENULOG, "Would you like to polymorph this Person? Y/N");
        while (true) {
            String input = scan.nextLine();
            if (input.equals("Y") || input.equals("y")) {
                logger.log(MENULOG, "1) Custodian");
                logger.log(MENULOG, "2) Gardener");
                logger.log(MENULOG, "3) Police Officer");
                logger.log(MENULOG, "4) Parking Enforcement Officer");
                logger.log(MENULOG, "5) Professor");
                logger.log(MENULOG, "6) Undergraduate Student");
                logger.log(MENULOG, "7) Graduate Student");
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
                            o.getPersonList().add(new UndergraduateStudent(firstName, lastName, "1640298", new HashSet<>(), 0));
                            break infiniteloop;
                        case "7":
                            o.getPersonList().add(new GraduateStudent(firstName, lastName, "1640298", new HashSet<>(), 0));
                            break infiniteloop;
                        default:
                            logger.warn("User has inputted a bad polymorph menu option");
                    }
                }
                break;
            } else if (input.equals("N") || input.equals("n")) {
                o.getPersonList().add(new UndergraduateStudent(firstName, lastName, "1640298", new HashSet<>(), 0));
                break;
            } else {
                logger.log(MENULOG, "Please select y/n");
            }
        }
        logger.debug(firstName + " " + lastName + " was successfully created!");
    }

    public final static void modifyPerson(University o, Scanner scan) throws InvalidSelectPersonIntegerException {
        for (int i = 0; i < o.getPersonList().size(); i++) {
            Person p = o.getPersonList().get(i);
            logger.log(MENULOG, i + ") " + p.getFirstName() + " " + p.getLastName() + " - " + p.getClass().getSimpleName());
        }
        logger.log(MENULOG, "Who would you like to modify?");
        infiniteloop:
        while (true) {
            String input = scan.nextLine();
            try {
                int index = Integer.parseInt(input);
                if (index >= 0 && index < o.getPersonList().size()) {
                    Person p = o.getPersonList().get(index);
                    logger.log(MENULOG, "What would you like to modify?");
                    logger.log(MENULOG, "0) First Name");
                    logger.log(MENULOG, "1) Last Name");
                    logger.log(MENULOG, "2) Course (if student or professor)");
                    input = scan.nextLine();
                    switch (input) {
                        case "0":
                            logger.log(MENULOG, "Enter First Name: ");
                            String firstName = scan.nextLine();
                            p.setFirstName(firstName);
                            break infiniteloop;
                        case "1":
                            logger.log(MENULOG, "Enter Last Name: ");
                            String lastName = scan.nextLine();
                            p.setLastName(lastName);
                            break infiniteloop;
                        case "2":
                            if (p instanceof Student || p instanceof FacultyStaff) {
                                logger.log(MENULOG, "These are all of the courses offered by the University");
                                for (Course c : o.getCourseSet()) {
                                    logger.log(MENULOG, c);
                                }
                                Set<Course> diff = new HashSet<>();
                                if (p instanceof Student) {
                                    logger.log(MENULOG, "These are all of the courses that the student is enrolled in");
                                    for (Course c : ((Student) p).getSchedule()) {
                                        logger.log(MENULOG, c);
                                    }
                                    diff = findCourseSetDifference(((Student) p).getSchedule(), o.getCourseSet());

                                } else if (p instanceof FacultyStaff) {
                                    logger.log(MENULOG, "These are all of the courses that the professor is enrolled in");
                                    for (Course c : ((FacultyStaff) p).getSchedule()) {
                                        logger.log(MENULOG, c);
                                    }
                                    diff = findCourseSetDifference(((FacultyStaff) p).getSchedule(), o.getCourseSet());
                                }
                                if (diff.isEmpty()) {
                                    logger.log(MENULOG, "The Person has already enrolled into all of the courses!");
                                } else {
                                    logger.log(MENULOG, "Which course would you like this Person to enroll in?");
                                    Course[] arr = diff.toArray(new Course[diff.size()]);
                                    for (int i = 0; i < arr.length; i++) {
                                        logger.log(MENULOG, i + ") " + arr[i]);
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
                                        logger.error("User has inputted an invalid integer when selecting a course");
                                        throw new InvalidSelectCourseIntegerException("User has inputted an invalid integer when selecting a course", e);
                                    }
                                }
                            } else {
                                logger.log(MENULOG, "This Person is not a student or professor");
                            }
                            break infiniteloop;

                    }
                }
            } catch (Exception e) {
                logger.error("User has inputted an invalid integer when selecting a person during modification");
                throw new InvalidSelectPersonIntegerException("User has inputted an invalid integer when selecting a person during modification", e);
            }
        }
        logger.debug("Successfully modified!");
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
            logger.log(MENULOG, i + ") " + p.getFirstName() + " " + p.getLastName() + " - " + p.getClass().getSimpleName());
        }
        logger.log(MENULOG, "Who would you like to delete?");
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
                logger.error("User has inputted an invalid integer when selecting a person during deletion");
                throw new InvalidSelectPersonIntegerException("User has inputted an invalid integer when selecting a person during deletion", e);
            }
        }
        logger.debug("Successfully deleted!");
    }

    public final static void createCourse(University o, Scanner scan) throws InvalidSelectCourseIntegerException {
        logger.log(MENULOG, "Input course title:");
        String courseTitle = scan.nextLine();
        logger.log(MENULOG, "Input major:");
        String major = scan.nextLine();
        infiniteloop:
        while (true) {
            logger.log(MENULOG, "Input days of the week as 7 bits. For example, 0101000 represents Mondays and Wednesdays");
            String days = scan.nextLine();
            if (Course.isDaysValid(days)) {
                try {
                    logger.log(MENULOG, "At what hour of the day does this class start? Pick a number in the range [0, 23])");
                    int hours = scan.nextInt();
                    logger.log(MENULOG, "At what minutes does it start? Pick a number in the range [0, 59]");
                    int minutes = scan.nextInt();
                    o.getCourseSet().add(new Course(courseTitle, major, days, LocalTime.of(hours, minutes)));
                    break infiniteloop;
                } catch (Exception e) {
                    logger.error("User has inputted an invalid integer when creating course");
                    throw new InvalidSelectCourseIntegerException("User has inputted an invalid integer when creating course" ,e);
                }
            }
            logger.warn("User has inputted an invalid integer when selecting a person during deletion");
        }
        logger.debug(courseTitle + " has been successfully created!");

    }

    public final static void testPerson(University o) {
        for (Person p : o.getPersonList()) {
            p.doWork();
        }
    }

    public final static void viewSchedule(University o) {
        for (Course c : o.getCourseSet()) {
            logger.log(MENULOG, c);
            boolean isEmpty = true;
            for (Person p : o.getPersonList()) {
                if (p instanceof Student) {
                    if (((Student) p).getSchedule().contains(c)) {
                        logger.log(MENULOG, p.getFirstName() + " " + p.getLastName() + " - " + p.getClass().getSimpleName());
                        isEmpty = false;
                    }
                } else if (p instanceof FacultyStaff) {
                    if (((FacultyStaff) p).getSchedule().contains(c)) {
                        logger.log(MENULOG, p.getFirstName() + " " + p.getLastName() + " - " + p.getClass().getSimpleName());
                        isEmpty = false;
                    }
                }
            }
            if (isEmpty) {
                logger.debug("No one is taking this course.");
            }
        }
    }

}