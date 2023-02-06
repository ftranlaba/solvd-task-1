package sql.datamodels.util;

import sql.datamodels.person.Customer;
import sql.datamodels.person.Person;

public class PersonDirector {
    private IPersonBuilder builder;

    private PersonDirector() {
    }

    public PersonDirector(IPersonBuilder o){
        builder = o;
    }

    public void changeBuilder(IPersonBuilder o){
        builder = o;
    }

    public Customer makeCustomerTypeOne(){
        builder.buildFirstName("Type");
        builder.buildLastName("One");
        Customer output = (Customer) builder.getResult();
        builder.reset();
        return output;
    }

    public Customer makeCustomerTypeTwo(){
        builder.buildFirstName("Type");
        builder.buildLastName("Two");
        builder.buildZipcode(12345);
        Customer output = (Customer) builder.getResult();
        builder.reset();
        return output;
    }


}
