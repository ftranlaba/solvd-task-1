package sql.xml.JAXB;

import sql.datamodels.entity.*;
import sql.datamodels.person.Customer;
import sql.datamodels.person.Employee;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class JAXBDriver {

    public static void main(String[] args) throws JAXBException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Francis", "Tran", "1", "1", "1", 1));
        customerList.add(new Customer("Francis", "Tran", "2", "2", "2", 2));
        customerList.add(new Customer("Francis", "Tran", "3", "3", "3", 3));
        List<Employee> employeeList = new ArrayList<>();
        List<City> cityList = new ArrayList<>();
        cityList.add(new City("Los Angeles"));
        cityList.add(new City("New York"));
        List<Country> countryList = new ArrayList<>();
        countryList.add(new Country("USA"));
        List<Manufacturer> manufacturerList = new ArrayList<>();
        manufacturerList.add(new Manufacturer("Nike", 1979));
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order(new Timestamp(12345), new Timestamp(12345)));
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(22, 1979));
        List<Shop> shopList = new ArrayList<>();
        shopList.add(new Shop(12345));
        List<State> stateList = new ArrayList<>();
        stateList.add(new State("California"));

        JAXBObjectHandler data = new JAXBObjectHandler(customerList, employeeList, cityList, countryList, manufacturerList, orderList, productList, shopList, stateList);
        JAXBContext context = JAXBContext.newInstance(JAXBObjectHandler.class);
        Marshaller mar = context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(data, new File("src/main/resources/jaxb_data.xml"));
    }
}
