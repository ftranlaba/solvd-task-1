package sql.service;


import sql.dao.*;
import sql.dao.jdbc.*;
import sql.datamodels.entity.*;
import sql.datamodels.person.Customer;
import sql.datamodels.person.Employee;

import java.util.List;

public class ServiceJDBC implements IService {
    private static final ICityDAO cityDao = new CityDAO();
    private static final ICountryDAO countryDao = new CountryDAO();
    private static final ICustomerDAO customerDAO = new CustomerDAO();
    private static final IEmployeeDAO employeeDAO = new EmployeeDAO();
    private static final IManufacturerDAO manufacturerDao = new ManufacturerDAO();
    private static final IOrderDAO orderDAO = new OrderDAO();
    private static final IProductDAO productDAO = new ProductDAO();
    private static final IShopDAO shopDAO = new ShopDAO();
    private static final IStateDAO stateDAO = new StateDAO();

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
    }

    @Override
    public void deleteCustomer(int id) {
        customerDAO.delete(id);
    }

    @Override
    public void createEmployee(Employee o) {
        employeeDAO.save(o);
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
    }

    @Override
    public void deleteEmployee(int id) {
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

    @Override
    public void createProduct(Product o) {
        productDAO.save(o);
    }

    @Override
    public Product readProduct(int id) {
        return productDAO.get(id).orElse(null);
    }

    @Override
    public List<Product> readAllProducts() {
        return productDAO.getAll();
    }

    @Override
    public void updateProduct(Product o, int id) {
        productDAO.update(o, id);
    }

    @Override
    public void deleteProduct(int id) {
        productDAO.delete(id);
    }

    @Override
    public void createShop(Shop o) {
        shopDAO.save(o);
    }

    @Override
    public Shop readShop(int id) {
        return shopDAO.get(id).orElse(null);
    }

    @Override
    public List<Shop> readAllShops() {
        return shopDAO.getAll();
    }

    @Override
    public void updateShop(Shop o, int id) {
        shopDAO.update(o, id);
    }

    @Override
    public void deleteShop(int id) {
        shopDAO.delete(id);
    }

    @Override
    public void createState(State o) {
        stateDAO.save(o);
    }

    @Override
    public State readState(int id) {
        return stateDAO.get(id).orElse(null);
    }

    @Override
    public List<State> readAllStates() {
        return stateDAO.getAll();
    }

    @Override
    public void updateState(State o, int id) {
        stateDAO.update(o, id);
    }

    @Override
    public void deleteState(int id) {
        stateDAO.delete(id);
    }
}
