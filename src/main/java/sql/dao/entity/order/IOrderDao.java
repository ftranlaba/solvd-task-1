package sql.dao.entity.order;

import sql.dao.IDao;
import sql.datamodels.entity.Order;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IOrderDao extends IDao<Order> {
    Optional<Order> get(Connection conn, int id) throws SQLException;

    List<Order> getAll(Connection conn) throws SQLException;

    void save(Connection conn, Order o) throws SQLException;

    void update(Connection conn, Order o, int id) throws SQLException;

    void delete(Connection conn, int id) throws SQLException;
}
