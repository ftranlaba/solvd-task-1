package sql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sql.dao.IBaseDAO;
import sql.dao.util.DBFactoryGenerator;
import sql.dao.util.enums.DBConnectionType;
import sql.datamodels.person.Customer;
import sql.datamodels.util.CustomerBuilder;
import sql.datamodels.util.IBuilder;
import sql.datamodels.util.IPersonBuilder;
import sql.service.IService;
import sql.service.ServiceJDBC;
import sql.service.ServiceMyBatis;

public class DesignPatternDriver {
    private static final Logger LOGGER = LogManager.getLogger("TESTLOGGER");

    public static void main(String[] args){
        IBuilder builder = new CustomerBuilder();
        IPersonBuilder personBuilder = (IPersonBuilder) builder;
        personBuilder.buildFirstName("Francis");
        personBuilder.buildLastName("Tran");
        personBuilder.buildAddress("123");
        personBuilder.buildPhoneNumber("777-777-7777");
        personBuilder.buildPhoneType("Home");
        personBuilder.buildZipcode(123);
        Customer customer = (Customer) personBuilder.getResult();

        IBaseDAO customerDAO = DBFactoryGenerator.getFactory(DBConnectionType.MYBATIS).getDAO("customer");
        customerDAO.save(customer);
        LOGGER.info(customerDAO.getAll());

        personBuilder.reset();
        personBuilder.buildFirstName("Kevin");
        personBuilder.buildLastName("Nguyen");
        personBuilder.buildAddress("123");
        personBuilder.buildPhoneNumber("777-777-7777");
        personBuilder.buildPhoneType("Home");
        personBuilder.buildZipcode(123);
        customer = (Customer) personBuilder.getResult();

        customerDAO = DBFactoryGenerator.getFactory(DBConnectionType.JDBC).getDAO("customer");
        customerDAO.save(customer);
        LOGGER.info(customerDAO.get(53));
    }
}
