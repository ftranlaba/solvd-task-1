import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public final class Test{

    public final static void print(Object o){
        System.out.println(o);
    }

    static{
        print("Example usage of static block here.");
    }

    public final static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        List<Person> personList = new ArrayList<>();
        University uni = new University("CSULB", 1967, personList);
        infiniteloop: while(true) {
            print("University Interaction Terminal Menu");
            if(personList.size() == 0){
                print("No one is attending this university.");
            }
            else{
                for(Person o : uni.getPersonList()){
                    print(o.getFirstName() + " " + o.getLastName() + " - " + o.getClass().getSimpleName());
                }
            }
            print("1) Create person object");
            print("2) Modify person object");
            print("3) Delete person object");
            print("4) Test doWork() on every person object");
            print("5) Exit program");
            String input = scan.nextLine();
            switch(input){
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
                    testPerson(uni);
                    break;
                case "5":
                    break infiniteloop;
                default:
                    print("BAD INPUT");
            }

        }
        scan.close();
        print("Exited successfully");
        
    }

    public final static void createPerson(University o, Scanner scan){
        print("Input first name:");
        String firstName = scan.nextLine();
        print("Input last name:");
        String lastName = scan.nextLine();
        print("Would you like to polymorph this person? Y/N");
        while(true){
            String input = scan.nextLine();
            if(input.equals("Y") || input.equals("y")){
                print("1) Custodian");
                print("2) Gardener");
                print("3) Police Officer");
                print("4) Parking Enforcement Officer");
                print("5) Professor");
                print("6) Undergraduate Student");
                print("7) Graduate Student");
                infiniteloop: while(true){
                    String input2 = scan.nextLine();
                    switch(input2){
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
                            o.getPersonList().add(new UndergraduateStudent(firstName, lastName, "1640298", 0));
                            break infiniteloop;
                        case "7":
                            o.getPersonList().add(new GraduateStudent(firstName, lastName, "1640298", 0));
                            break infiniteloop;
                        default:
                            print("BAD INPUT");
                    }
                }
                break;

            }
            else if(input.equals("N") || input.equals("n")){
                o.getPersonList().add(new UndergraduateStudent(firstName, lastName, "1640298", 0));
                break;
            }
            else{
                print("Please select y/n");
            }
        }
        print(firstName + " " + lastName + " was sucessfully created!");


    }

    public final static void modifyPerson(University o, Scanner scan){
        for(int i = 0; i < o.getPersonList().size(); i++){
            print(i + ") " + o.getPersonList().get(i));
        }
        print("Who would you like to modify?");
        infiniteloop: while(true) {
            String input = scan.nextLine();
            try {
                int index = Integer.parseInt(input);
                if (index >= 0 && index < o.getPersonList().size()) {
                    print("For simple purposes, let's just modify the person's first name. Please input desired first name");
                    String firstName = scan.nextLine();
                    o.getPersonList().get(index).setFirstName(firstName);
                    break infiniteloop;
                }
            } catch (Exception e) {
                print("Bad input");
            }
        }
        print("Successfully modified!");
    }

    // LinkedList would perform better than ArrayList here
    public final static void deletePerson(University o, Scanner scan){
        for(int i = 0; i < o.getPersonList().size(); i++){
            print(i + ") " + o.getPersonList().get(i));
        }
        print("Who would you like to delete?");
        infiniteloop: while(true) {
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

    public final static void testPerson(University o){
        for(Person p : o.getPersonList()){
            p.doWork();
        }
    }

}