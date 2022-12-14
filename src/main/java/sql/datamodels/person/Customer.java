package sql.datamodels.person;

public class Customer extends Person {
    public Customer() {
        super();
    }

    public Customer(String firstName, String lastName, String address, String phoneType, String phoneNumber, int zipcode) {
        super(firstName, lastName, address, phoneType, phoneNumber, zipcode);
    }

    public Customer(Object[] arr) {
        super(arr[0] + "", arr[1] + "", arr[2] + "", arr[3] + "", arr[4] + "", Integer.parseInt(arr[5] + ""));
    }
}
