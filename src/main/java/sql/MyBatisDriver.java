package sql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sql.dao.ICustomerDAO;
import sql.dao.mybatis.CustomerDAO;
import sql.datamodels.person.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MyBatisDriver {
    private static final Logger LOGGER = LogManager.getLogger("TESTLOGGER");

    public static void main(String[] args){
        ICustomerDAO customerDAO =  new CustomerDAO();
        Optional customer = customerDAO.get(1);
        LOGGER.info("GET: " + customer);

        customerDAO.save(new Customer("FRANCIS", "TRAN", "ADDRESS", "WORK", "7777777", 123));

        List<Customer> customerList = customerDAO.getAll();
        LOGGER.info("GETALL: " + customerList);

    }
}
