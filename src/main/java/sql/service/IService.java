package sql.service;

import sql.datamodels.entity.City;
import sql.datamodels.entity.Country;
import sql.datamodels.entity.Manufacturer;
import sql.datamodels.entity.Order;
import sql.datamodels.person.Customer;
import sql.datamodels.person.Employee;

import java.util.List;

public interface IService {
    void createCity(City o);

    City readCity(int id);

    List<City> readAllCities();

    void updateCity(City o, int id);

    void deleteCity(int id);

    void createCountry(Country o);

    Country readCountry(int id);

    List<Country> readAllCountries();

    void updateCountry(Country o, int id);

    void deleteCountry(int id);

    void createCustomer(Customer o);

    Customer readCustomer(int id);

    List<Customer> readAllCustomers();

    void updateCustomer(Customer o, int id);

    void deleteCustomer(int id);

    void createEmployee(Employee o);

    Employee readEmployee(int id);

    List<Employee> readAllEmployees();

    void updateEmployee(Employee o, int id);

    void deleteEmployee(int id);

    void createManufacturer(Manufacturer o);

    Manufacturer readManufacturer(int id);

    List<Manufacturer> readAllManufacturers();

    void updateManufacturer(Manufacturer o, int id);

    void deleteManufacturer(int id);

    void createOrder(Order o);

    Order readOrder(int id);

    List<Order> readAllOrders();

    void updateOrder(Order o, int id);

    void deleteOrder(int id);


}
