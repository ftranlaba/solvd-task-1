package sql.dao.entity.product;

import sql.dao.IDao;
import sql.datamodels.entity.Country;
import sql.datamodels.entity.Manufacturer;
import sql.datamodels.entity.Order;
import sql.datamodels.entity.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IProductDao extends IDao<Product> {
    Optional<Product> get(Connection conn, int id) throws SQLException;

    List<Product> getAll(Connection conn) throws SQLException;

    void save(Connection conn, Product o) throws SQLException;

    void update(Connection conn, Product o, int id) throws SQLException;

    void delete(Connection conn, int id) throws SQLException;
}
