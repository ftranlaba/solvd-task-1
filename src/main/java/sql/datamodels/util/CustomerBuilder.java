package sql.datamodels.util;

import sql.datamodels.person.Customer;
import sql.datamodels.person.Person;

public class CustomerBuilder implements IPersonBuilder{
    Customer output = new Customer();

    @Override
    public void reset() {
        output = new Customer();
    }

    @Override
    public void buildFirstName(String s) {
        output.setFirstName(s);
    }

    @Override
    public void buildLastName(String s) {
        output.setLastName(s);
    }

    @Override
    public void buildAddress(String s) {
        output.setAddress(s);
    }

    @Override
    public void buildPhoneType(String s) {
        output.setPhoneType(s);
    }

    @Override
    public void buildPhoneNumber(String s) {
        output.setPhoneNumber(s);
    }

    @Override
    public void buildZipcode(int num) {
        output.setZipcode(num);
    }

    @Override
    public Person getResult() {
        return output;
    }
}
