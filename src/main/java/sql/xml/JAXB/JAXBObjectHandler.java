package sql.xml.JAXB;

import sql.datamodels.entity.*;
import sql.datamodels.person.Customer;
import sql.datamodels.person.Employee;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Data")
@XmlType(propOrder = {"customerList", "employeeList", "cityList", "countryList", "manufacturerList", "orderList", "productList", "shopList", "stateList"})
public class JAXBObjectHandler {
    private List<Customer> customerList;
    private List<Employee> employeeList;
    private List<City> cityList;
    private List<Country> countryList;
    private List<Manufacturer> manufacturerList;
    private List<Order> orderList;
    private List<Product> productList;
    private List<Shop> shopList;
    private List<State> stateList;

    public JAXBObjectHandler() {
        customerList = new ArrayList<>();
        employeeList = new ArrayList<>();
        cityList = new ArrayList<>();
        countryList = new ArrayList<>();
        manufacturerList = new ArrayList<>();
        orderList = new ArrayList<>();
        productList = new ArrayList<>();
        shopList = new ArrayList<>();
        stateList = new ArrayList<>();
    }

    public JAXBObjectHandler(List<Customer> customerList, List<Employee> employeeList, List<City> cityList, List<Country> countryList, List<Manufacturer> manufacturerList, List<Order> orderList, List<Product> productList, List<Shop> shopList, List<State> stateList) {
        this.customerList = customerList;
        this.employeeList = employeeList;
        this.cityList = cityList;
        this.countryList = countryList;
        this.manufacturerList = manufacturerList;
        this.orderList = orderList;
        this.productList = productList;
        this.shopList = shopList;
        this.stateList = stateList;
    }

    @XmlElementWrapper(name="Customers")
    @XmlElement(name = "Customer")
    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    @XmlElementWrapper(name = "Employees")
    @XmlElement(name = "Employee")
    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @XmlElementWrapper(name = "Cities")
    @XmlElement(name = "City")
    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    @XmlElementWrapper(name = "Countries")
    @XmlElement(name = "Country")
    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    @XmlElementWrapper(name = "Manufacturers")
    @XmlElement(name = "Manufacturer")
    public void setManufacturerList(List<Manufacturer> manufacturerList) {
        this.manufacturerList = manufacturerList;
    }

    @XmlElementWrapper(name = "Orders")
    @XmlElement(name = "Order")
    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @XmlElementWrapper(name = "Products")
    @XmlElement(name = "Product")
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @XmlElementWrapper(name = "Shops")
    @XmlElement(name = "Shop")
    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }

    @XmlElementWrapper(name = "States")
    @XmlElement(name = "State")
    public void setStateList(List<State> stateList) {
        this.stateList = stateList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public List<Manufacturer> getManufacturerList() {
        return manufacturerList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public List<State> getStateList() {
        return stateList;
    }
}