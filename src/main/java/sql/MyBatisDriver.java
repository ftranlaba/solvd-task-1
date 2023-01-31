package sql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sql.dao.*;
import sql.dao.mybatis.*;
import sql.datamodels.entity.*;
import sql.datamodels.person.Customer;
import sql.datamodels.person.Employee;

import java.sql.Timestamp;
import java.util.List;

public class MyBatisDriver {
    private static final Logger LOGGER = LogManager.getLogger("TESTLOGGER");

    public static void main(String[] args) {
        executeCity();
        executeCountry();
        executeManufacturer();
        executeEmployee();
        executeCustomer();
        executeOrder();

    }

    public static void executeCustomer() {
        ICustomerDAO customerDAO = new CustomerDAO();

        Customer customer1 = new Customer(15, "FRANCIS", "TRAN", "ADDRESS", "WORK", "7777777", 123);
        customerDAO.save(customer1);
        ((ICustomerDAOMyBatis) customerDAO).savePhone(customer1);
        LOGGER.info("GET NEW CREATED CUSTOMER: " + customerDAO.get(customer1.getId()));

        customer1.setFirstName("francis-tran");
        customer1.setPhoneType("work-home");
        customerDAO.update(customer1, customer1.getId());
        ((ICustomerDAOMyBatis) customerDAO).updatePhone(customer1, customer1.getId());
        LOGGER.info("GET NEW UPDATED CUSTOMER: " + customerDAO.get(customer1.getId()));

        List<Customer> customerList = customerDAO.getAll();
        LOGGER.info("GETALL: " + customerList);

        ((ICustomerDAOMyBatis) customerDAO).deletePhone(customer1.getId());
        customerDAO.delete(customer1.getId());
        customerList = customerDAO.getAll();
        LOGGER.info("GETALL AFTER DELETE NEW CUSTOMER: " + customerList);
        LOGGER.info("CUSTOMER QUERY DONE\n");
    }

    public static void executeEmployee() {
        IEmployeeDAO employeeDAO = new EmployeeDAO();

        Employee employee1 = new Employee(15, "FRANCIS", "TRAN", "ADDRESS", "WORK", "7777777", 123);
        employeeDAO.save(employee1);
        ((IEmployeeDAOMyBatis) employeeDAO).savePhone(employee1);
        LOGGER.info("GET NEW CREATED EMPLOYEE: " + employeeDAO.get(employee1.getId()));

        employee1.setFirstName("francis-tran");
        employee1.setPhoneType("work-home");
        employeeDAO.update(employee1, employee1.getId());
        ((IEmployeeDAOMyBatis) employeeDAO).updatePhone(employee1, employee1.getId());
        LOGGER.info("GET NEW UPDATED EMPLOYEE: " + employeeDAO.get(employee1.getId()));

        List<Employee> employeeList = employeeDAO.getAll();
        LOGGER.info("GETALL: " + employeeList);

        ((IEmployeeDAOMyBatis) employeeDAO).deletePhone(employee1.getId());
        employeeDAO.delete(employee1.getId());
        employeeList = employeeDAO.getAll();
        LOGGER.info("GETALL AFTER DELETE NEW EMPLOYEE: " + employeeList);
        LOGGER.info("EMPLOYEE QUERY DONE\n");
    }

    public static void executeCity() {
        ICityDAO cityDAO = new CityDAO();

        City city1 = new City(1, "Los Angeles");
        cityDAO.save(city1);
        LOGGER.info("GET NEW CREATED CITY: " + cityDAO.get(city1.getId()));

        city1.setName("New York");
        cityDAO.update(city1, city1.getId());
        LOGGER.info("GET NEW UPDATED CITY: " + cityDAO.get(city1.getId()));

        List<City> cityList = cityDAO.getAll();
        LOGGER.info("GETALL: " + cityList);

        cityDAO.delete(city1.getId());
        cityList = cityDAO.getAll();
        LOGGER.info("GETALL AFTER DELETE NEW CITY: " + cityList);
        LOGGER.info("CITY QUERY DONE\n");
    }

    public static void executeCountry() {
        ICountryDAO countryDAO = new CountryDAO();

        Country country1 = new Country(1, "USA");
        countryDAO.save(country1);
        LOGGER.info("GET NEW CREATED COUNTRY: " + countryDAO.get(country1.getId()));

        country1.setName("Canada");
        countryDAO.update(country1, country1.getId());
        LOGGER.info("GET NEW UPDATED COUNTRY: " + countryDAO.get(country1.getId()));

        List<Country> countryList = countryDAO.getAll();
        LOGGER.info("GETALL: " + countryList);

        countryDAO.delete(country1.getId());
        countryList = countryDAO.getAll();
        LOGGER.info("GETALL AFTER DELETE NEW COUNTRY: " + countryList);
        LOGGER.info("COUNTRY QUERY DONE\n");
    }

    public static void executeManufacturer() {
        IManufacturerDAO manufacturerDAO = new ManufacturerDAO();

        Manufacturer manufacturer1 = new Manufacturer(1, "Nike", 1988);
        manufacturerDAO.save(manufacturer1);
        LOGGER.info("GET NEW CREATED MANUFACTURER: " + manufacturerDAO.get(manufacturer1.getId()));

        manufacturer1.setName("Adidas");
        manufacturerDAO.update(manufacturer1, manufacturer1.getId());
        LOGGER.info("GET NEW UPDATED MANUFACTURER: " + manufacturerDAO.get(manufacturer1.getId()));

        List<Manufacturer> countryList = manufacturerDAO.getAll();
        LOGGER.info("GETALL: " + countryList);

        manufacturerDAO.delete(manufacturer1.getId());
        countryList = manufacturerDAO.getAll();
        LOGGER.info("GETALL AFTER DELETE NEW MANUFACTURER: " + countryList);
        LOGGER.info("MANUFACTURER QUERY DONE\n");
    }

    public static void executeOrder() {
        IOrderDAO orderDAO = new OrderDAO();

        Order order1 = new Order(1, new Timestamp(12345), new Timestamp(12345));
        orderDAO.save(order1);
        LOGGER.info("GET NEW CREATED ORDER: " + orderDAO.get(order1.getId()));

        order1.setStartDate(new Timestamp(999999));
        orderDAO.update(order1, order1.getId());
        LOGGER.info("GET NEW UPDATED ORDER: " + orderDAO.get(order1.getId()));

        List<Order> orderList = orderDAO.getAll();
        LOGGER.info("GETALL: " + orderList);

        orderDAO.delete(order1.getId());
        orderList = orderDAO.getAll();
        LOGGER.info("GETALL AFTER DELETE NEW ORDER: " + orderList);
        LOGGER.info("ORDER QUERY DONE\n");
    }

    public static void executeProduct() {
        IProductDAO productDAO = new ProductDAO();

        Product product1 = new Product(1, "shoes", 5, 10);
        productDAO.save(product1);
        LOGGER.info("GET NEW CREATED PRODUCT: " + productDAO.get(product1.getId()));

        product1.setPrice(20);
        productDAO.update(product1, product1.getId());
        LOGGER.info("GET NEW UPDATED PRODUCT: " + productDAO.get(product1.getId()));

        List<Product> orderList = productDAO.getAll();
        LOGGER.info("GETALL: " + orderList);

        productDAO.delete(product1.getId());
        orderList = productDAO.getAll();
        LOGGER.info("GETALL AFTER DELETE NEW PRODUCT: " + orderList);
        LOGGER.info("PRODUCT QUERY DONE\n");
    }

    public static void executeShop() {
        IShopDAO shopDAO = new ShopDAO();

        Shop shop1 = new Shop(1, 11111);
        shopDAO.save(shop1);
        LOGGER.info("GET NEW CREATED SHOP: " + shopDAO.get(shop1.getId()));

        shop1.setZipcode(55555);
        shopDAO.update(shop1, shop1.getId());
        LOGGER.info("GET NEW UPDATED SHOP: " + shopDAO.get(shop1.getId()));

        List<Shop> orderList = shopDAO.getAll();
        LOGGER.info("GETALL: " + orderList);

        shopDAO.delete(shop1.getId());
        orderList = shopDAO.getAll();
        LOGGER.info("GETALL AFTER DELETE NEW SHOP: " + orderList);
        LOGGER.info("SHOP QUERY DONE\n");
    }

    public static void executeState() {
        IStateDAO stateDAO = new StateDAO();

        State state1 = new State(1, "California");
        stateDAO.save(state1);
        LOGGER.info("GET NEW CREATED STATE: " + stateDAO.get(state1.getId()));

        state1.setName("Utah");
        stateDAO.update(state1, state1.getId());
        LOGGER.info("GET NEW UPDATED STATE: " + stateDAO.get(state1.getId()));

        List<State> orderList = stateDAO.getAll();
        LOGGER.info("GETALL: " + orderList);

        stateDAO.delete(state1.getId());
        orderList = stateDAO.getAll();
        LOGGER.info("GETALL AFTER DELETE NEW STATE: " + orderList);
        LOGGER.info("STATE QUERY DONE\n");
    }

}
