package sql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sql.datamodels.person.Customer;
import sql.datamodels.util.CustomerBuilder;
import sql.datamodels.util.PersonDirector;

public class DatamodelBuilderDriver {
    private static final Logger LOGGER = LogManager.getLogger("TESTLOGGER");
    public static void main(String[] args){
        PersonDirector personDirector = new PersonDirector(new CustomerBuilder());

        Customer customer = personDirector.makeCustomerTypeOne();
        LOGGER.info(customer);

        customer = personDirector.makeCustomerTypeTwo();
        LOGGER.info(customer);
    }
}
