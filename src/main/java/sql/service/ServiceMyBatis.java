package sql.service;

import sql.dao.*;
import sql.dao.mybatis.*;
import sql.datamodels.entity.City;
import sql.datamodels.entity.Country;
import sql.datamodels.entity.Manufacturer;
import sql.datamodels.entity.Order;
import sql.datamodels.person.Customer;
import sql.datamodels.person.Employee;

import java.util.List;

public class ServiceMyBatis implements IService {
    private static final ICityDAO cityDao = new CityDAO();
    private static final ICountryDAO countryDao = new CountryDAO();
    private static final ICustomerDAO customerDAO = new CustomerDAO();
    private static final IEmployeeDAO employeeDAO = new EmployeeDAO();
    private static final IManufacturerDAO manufacturerDao = new ManufacturerDAO();
    private static final IOrderDAO orderDAO = new OrderDAO();

    @Override
    public void createCity(City o) {
        cityDao.save(o);
    }

    @Override
    public City readCity(int id) {
        return cityDao.get(id).orElse(null);
    }

    @Override
    public List<City> readAllCities() {
        return cityDao.getAll();
    }

    @Override
    public void updateCity(City o, int id) {
        cityDao.update(o, id);
    }

    @Override
    public void deleteCity(int id) {
        cityDao.delete(id);
    }

    @Override
    public void createCountry(Country o) {
        countryDao.save(o);
    }

    @Override
    public Country readCountry(int id) {
        return countryDao.get(id).orElse(null);
    }

    @Override
    public List<Country> readAllCountries() {
        return countryDao.getAll();
    }

    @Override
    public void updateCountry(Country o, int id) {
        countryDao.update(o, id);
    }

    @Override
    public void deleteCountry(int id) {
        countryDao.delete(id);
    }

    @Override
    public void createCustomer(Customer o) {
        customerDAO.save(o);
        customerDAO.savePhone(o);
    }

    @Override
    public Customer readCustomer(int id) {
        return (Customer) customerDAO.get(id).orElse(null);
    }

    @Override
    public List<Customer> readAllCustomers() {
        return customerDAO.getAll();
    }

    @Override
    public void updateCustomer(Customer o, int id) {
        customerDAO.update(o, id);
        customerDAO.updatePhone(o, id);
    }

    @Override
    public void deleteCustomer(int id) {
        customerDAO.deletePhone(id);
        customerDAO.delete(id);
    }

    @Override
    public void createEmployee(Employee o) {
        employeeDAO.save(o);
        employeeDAO.savePhone(o);
    }

    @Override
    public Employee readEmployee(int id) {
        return (Employee) employeeDAO.get(id).orElse(null);
    }

    @Override
    public List<Employee> readAllEmployees() {
        return employeeDAO.getAll();
    }

    @Override
    public void updateEmployee(Employee o, int id) {
        employeeDAO.update(o, id);
        employeeDAO.updatePhone(o, id);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDAO.deletePhone(id);
        employeeDAO.delete(id);
    }

    @Override
    public void createManufacturer(Manufacturer o) {
        manufacturerDao.save(o);
    }

    @Override
    public Manufacturer readManufacturer(int id) {
        return manufacturerDao.get(id).orElse(null);
    }

    @Override
    public List<Manufacturer> readAllManufacturers() {
        return manufacturerDao.getAll();
    }

    @Override
    public void updateManufacturer(Manufacturer o, int id) {
        manufacturerDao.update(o, id);
    }

    @Override
    public void deleteManufacturer(int id) {
        manufacturerDao.delete(id);
    }

    @Override
    public void createOrder(Order o) {
        orderDAO.save(o);
    }

    @Override
    public Order readOrder(int id) {
        return orderDAO.get(id).orElse(null);
    }

    @Override
    public List<Order> readAllOrders() {
        return orderDAO.getAll();
    }

    @Override
    public void updateOrder(Order o, int id) {
        orderDAO.update(o, id);
    }

    @Override
    public void deleteOrder(int id) {
        orderDAO.delete(id);
    }
}
