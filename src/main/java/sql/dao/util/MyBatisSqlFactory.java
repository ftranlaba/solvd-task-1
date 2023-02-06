package sql.dao.util;

import sql.dao.IBaseDAO;
import sql.dao.mybatis.*;
import sql.dao.util.exceptions.UnsupportedFactoryException;

public class MyBatisSqlFactory implements IDAOFactory {
    @Override
    public IBaseDAO getDAO(String modal) {
        switch(modal.toLowerCase()) {
            case "customer":
                return new CustomerDAO();
            case "employee":
                return new EmployeeDAO();
            case "city":
                return new CityDAO();
            case "country":
                return new CountryDAO();
            case "manufacturer":
                return new ManufacturerDAO();
            case "order":
                return new OrderDAO();
            case "product":
                return new ProductDAO();
            case "shop":
                return new ShopDAO();
            case "state":
                return new StateDAO();
            default:
                throw new UnsupportedFactoryException("JDBC Factory Type not supported.");
        }
    }
}
