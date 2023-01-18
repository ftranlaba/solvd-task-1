package sql.datamodels.person;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Employee")
public class Employee extends Person {
    public Employee() {
        super();
    }

    public Employee(String firstName, String lastName, String address, String phoneType, String phoneNumber, int zipcode) {
        super(firstName, lastName, address, phoneType, phoneNumber, zipcode);
    }

    public Employee(Object[] arr) {
        super(arr[0] + "", arr[1] + "", arr[2] + "", arr[3] + "", arr[4] + "", Integer.parseInt(arr[5] + ""));
    }
}
