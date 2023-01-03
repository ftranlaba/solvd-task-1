package sql.dao.entity.order;

import sql.datamodels.entity.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderDaoMysql implements IOrderDao {

    @Override
    public Optional get(Connection conn, int id) throws SQLException {
        //public Order(Timestamp startDate, Timestamp endDate)
        String sql = "SELECT start_date, end_date FROM orders WHERE id_order = ?";
        return Optional.ofNullable(new Order(genericGet(conn, sql, id)));
    }

    @Override
    public List getAll(Connection conn) throws SQLException {
        //public Order(Timestamp startDate, Timestamp endDate)
        String sql = "SELECT start_date, end_date FROM orders";
        List<Object[]> list = genericGet(conn, sql);
        List<Order> output = new ArrayList<>();
        for (Object[] o : list) {
            output.add(new Order(o));
        }
        return output;
    }

    @Override
    public void save(Connection conn, Order o) throws SQLException {
        String sql = "INSERT INTO orders(name, year) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setTimestamp(1, o.getStartDate());
        stmt.setTimestamp(2, o.getEndDate());
        stmt.execute();
        stmt.close();
    }

    @Override
    public void update(Connection conn, Order o, int id) throws SQLException {
        String sql = "UPDATE orders SET start_date = ?, end_date = ? WHERE id_order = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setTimestamp(1, o.getStartDate());
        stmt.setTimestamp(2, o.getEndDate());
        stmt.setInt(3, id);
        stmt.execute();
        stmt.close();
    }

    @Override
    public void delete(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM orders WHERE id_order = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
    }
}
