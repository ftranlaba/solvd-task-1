package sql.datamodels.person;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Employee")
public class Employee extends Person {
    public Employee() {
        super();
    }

    public Employee(String firstName, String lastName, String address, String phoneType, String phoneNumber, int zipcode) {
        super(firstName, address, phoneType, lastName, zipcode, phoneNumber);
    }

    public Employee(int id, String firstName, String lastName, String address, String phoneType, String phoneNumber, int zipcode) {
        super(firstName, address, phoneType, lastName, zipcode, phoneNumber);
    }

    public Employee(Object[] arr) {
        super(arr[0] + "", arr[2] + "", arr[3] + "", arr[1] + "", Integer.parseInt(arr[5] + ""), arr[4] + "");
    }
}
