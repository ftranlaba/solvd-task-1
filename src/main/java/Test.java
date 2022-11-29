import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


import entity.*;
import entity.person.Person;
import entity.person.staff.cleaner.*;
import entity.person.staff.enforcement.*;
import entity.person.staff.faculty.*;
import entity.person.student.*;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public final class Test {

    private static boolean dataLoaded = false;
    final static Level STATICLOG = Level.forName("STATICLOG", 699);
    final static Level MENULOG = Level.forName("MENULOG", 700);
    private static Logger logger = LogManager.getLogger(Test.class);

    static {
        print("Example usage of static block here.");
    }

    public final static void print(Object o) {
        System.out.println(o);
    }

    public final static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
        University uni = new University("CSULB", 1967, personList, new HashSet<>());
        infiniteloop:
        while (true) {
            logger.log(MENULOG, "University Interaction Terminal Menu");
            if (personList.size() == 0) {
                print("No one is attending this university.");
            } else {
                for (Person o : uni.getPersonList()) {
                    print(o.getFirstName() + " " + o.getLastName() + " - " + o.getClass().getSimpleName());
                }
            }
            print("0) Load default data");
            print("1) Create Person object");
            print("2) Modify Person object");
            print("3) Delete Person object");
            print("4) Create course object");
            print("5) Test doWork() on every Person object");
            print("6) View students and professor schedule");
            print("7) Exit program");
            String input = scan.nextLine();
            switch (input) {
                case "0":
                    if (!dataLoaded) {
                        Seeder.seedDefaultData(uni);
                        dataLoaded = true;
                    } else {
                        print("Default data is already loaded.");
                    }
                    break;
                case "1":
                    createPerson(uni, scan);
                    break;
                case "2":
                    modifyPerson(uni, scan);
                    break;
                case "3":
                    deletePerson(uni, scan);
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
                    break infiniteloop;
                default:
                    print("BAD INPUT");
            }
        }
        scan.close();
        print("Exited successfully");

    }

    public final static void createPerson(University o, Scanner scan) {
        print("Input first name:");
        String firstName = scan.nextLine();
        print("Input last name:");
        String lastName = scan.nextLine();
        print("Would you like to polymorph this Person? Y/N");
        while (true) {
            String input = scan.nextLine();
            if (input.equals("Y") || input.equals("y")) {
                print("1) Custodian");
                print("2) Gardener");
                print("3) Police Officer");
                print("4) Parking Enforcement Officer");
                print("5) Professor");
                print("6) Undergraduate Student");
                print("7) Graduate Student");
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
                            print("BAD INPUT");
                    }
                }
                break;
            } else if (input.equals("N") || input.equals("n")) {
                o.getPersonList().add(new UndergraduateStudent(firstName, lastName, "1640298", new HashSet<>(), 0));
                break;
            } else {
                print("Please select y/n");
            }
        }
        print(firstName + " " + lastName + " was successfully created!");
    }

    public final static void modifyPerson(University o, Scanner scan) {
        for (int i = 0; i < o.getPersonList().size(); i++) {
            Person p = o.getPersonList().get(i);
            print(i + ") " + p.getFirstName() + " " + p.getLastName() + " - " + p.getClass().getSimpleName());
        }
        print("Who would you like to modify?");
        infiniteloop:
        while (true) {
            String input = scan.nextLine();
            try {
                int index = Integer.parseInt(input);
                if (index >= 0 && index < o.getPersonList().size()) {
                    Person p = o.getPersonList().get(index);
                    print("What would you like to modify?");
                    print("0) First Name");
                    print("1) Last Name");
                    print("2) Course (if student or professor)");
                    input = scan.nextLine();
                    switch (input) {
                        case "0":
                            print("Enter First Name: ");
                            String firstName = scan.nextLine();
                            p.setFirstName(firstName);
                            break infiniteloop;
                        case "1":
                            print("Enter Last Name: ");
                            String lastName = scan.nextLine();
                            p.setLastName(lastName);
                            break infiniteloop;
                        case "2":
                            if (p instanceof Student || p instanceof FacultyStaff) {
                                print("These are all of the courses offered by the University");
                                for (Course c : o.getCourseSet()) {
                                    print(c);
                                }
                                Set<Course> diff = new HashSet<>();
                                if (p instanceof Student) {
                                    print("These are all of the courses that the student is enrolled in");
                                    for (Course c : ((Student) p).getSchedule()) {
                                        print(c);
                                    }
                                    diff = findCourseSetDifference(((Student) p).getSchedule(), o.getCourseSet());

                                } else if (p instanceof FacultyStaff) {
                                    print("These are all of the courses that the professor is enrolled in");
                                    for (Course c : ((FacultyStaff) p).getSchedule()) {
                                        print(c);
                                    }
                                    diff = findCourseSetDifference(((FacultyStaff) p).getSchedule(), o.getCourseSet());
                                }
                                if (diff.isEmpty()) {
                                    print("The Person has already enrolled into all of the courses!");
                                } else {
                                    print("Which course would you like this Person to enroll in?");
                                    Course[] arr = diff.toArray(new Course[diff.size()]);
                                    for (int i = 0; i < arr.length; i++) {
                                        print(i + ") " + arr[i]);
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
                                        print("BAD INPUT");
                                    }
                                }
                            } else {
                                print("This Person is not a student or professor");
                            }
                            break infiniteloop;

                    }
                }
            } catch (Exception e) {
                print("Bad input");
            }
        }
        print("Successfully modified!");
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
    public final static void deletePerson(University o, Scanner scan) {
        for (int i = 0; i < o.getPersonList().size(); i++) {
            Person p = o.getPersonList().get(i);
            print(i + ") " + p.getFirstName() + " " + p.getLastName() + " - " + p.getClass().getSimpleName());
        }
        print("Who would you like to delete?");
        infiniteloop:
        while (true) {
            String input = scan.nextLine();
            try {
                int index = Integer.parseInt(input);
                if (index >= 0 && index < o.getPersonList().size()) {
                    o.getPersonList().remove(index);
                    break infiniteloop;
                }
            } catch (Exception e) {
                print("Bad input");
            }
        }
        print("Successfully deleted!");
    }

    public final static void createCourse(University o, Scanner scan) {
        print("Input course title:");
        String courseTitle = scan.nextLine();
        print("Input major:");
        String major = scan.nextLine();
        infiniteloop:
        while (true) {
            print("Input days of the week as 7 bits. For example, 0101000 represents Mondays and Wednesdays");
            String days = scan.nextLine();
            if (Course.isDaysValid(days)) {
                try {
                    print("At what hour of the day does this class start? Pick a number in the range [0, 23])");
                    int hours = scan.nextInt();
                    print("At what minutes does it start? Pick a number in the range [0, 59]");
                    int minutes = scan.nextInt();
                    o.getCourseSet().add(new Course(courseTitle, major, days, LocalTime.of(hours, minutes)));
                    break infiniteloop;
                } catch (Exception e) {
                    print("BAD INPUT");
                }
            }
            print("BAD INPUT");
        }
        print(courseTitle + " has been successfully created!");

    }

    public final static void testPerson(University o) {
        for (Person p : o.getPersonList()) {
            p.doWork();
        }
    }

    public final static void viewSchedule(University o) {
        for (Course c : o.getCourseSet()) {
            print(c);
            boolean isEmpty = true;
            for (Person p : o.getPersonList()) {
                if (p instanceof Student) {
                    if (((Student) p).getSchedule().contains(c)) {
                        print(p.getFirstName() + " " + p.getLastName() + " - " + p.getClass().getSimpleName());
                        isEmpty = false;
                    }
                } else if (p instanceof FacultyStaff) {
                    if (((FacultyStaff) p).getSchedule().contains(c)) {
                        print(p.getFirstName() + " " + p.getLastName() + " - " + p.getClass().getSimpleName());
                        isEmpty = false;
                    }
                }
            }
            if (isEmpty) {
                print("No one is taking this course.");
            }
        }
    }

}