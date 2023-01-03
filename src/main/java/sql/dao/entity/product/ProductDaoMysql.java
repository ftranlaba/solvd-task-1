package sql.dao.entity.product;

import sql.datamodels.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDaoMysql implements IProductDao {

    @Override
    public Optional get(Connection conn, int id) throws SQLException {
        //public Product(String name, int price, int amount)
        String sql = "SELECT name, price, amount FROM products WHERE id_product = ?";
        return Optional.ofNullable(new Product(genericGet(conn, sql, id)));
    }

    @Override
    public List getAll(Connection conn) throws SQLException {
        //public Product(String name, int price, int amount)
        String sql = "SELECT name, price, amount FROM products";
        List<Object[]> list = genericGet(conn, sql);
        List<Product> output = new ArrayList<>();
        for (Object[] o : list) {
            output.add(new Product(o));
        }
        return output;
    }

    @Override
    public void save(Connection conn, Product o) throws SQLException {
        String sql = "INSERT INTO products(name, price, amount) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, o.getName());
        stmt.setInt(2, o.getPrice());
        stmt.setInt(3, o.getAmount());
        stmt.execute();
        stmt.close();
    }

    @Override
    public void update(Connection conn, Product o, int id) throws SQLException {
        String sql = "UPDATE products SET name = ?, price = ?, amount = ? WHERE id_product = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, o.getName());
        stmt.setInt(2, o.getPrice());
        stmt.setInt(3, o.getAmount());
        stmt.setInt(4, id);
        stmt.execute();
        stmt.close();
    }

    @Override
    public void delete(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM products WHERE id_product = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
    }
}
