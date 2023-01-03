package sql.dao.entity.shop;

import sql.datamodels.entity.Shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShopDaoMysql implements IShopDao {

    @Override
    public Optional get(Connection conn, int id) throws SQLException {
        //public Shop(int zipcode)
        String sql = "SELECT zipcode FROM shops WHERE id_shop = ?";
        return Optional.ofNullable(new Shop(genericGet(conn, sql, id)));
    }

    @Override
    public List getAll(Connection conn) throws SQLException {
        //public Shop(int zipcode)
        String sql = "SELECT zipcode FROM shops";
        List<Object[]> list = genericGet(conn, sql);
        List<Shop> output = new ArrayList<>();
        for (Object[] o : list) {
            output.add(new Shop(o));
        }
        return output;
    }

    @Override
    public void save(Connection conn, Shop o) throws SQLException {
        String sql = "INSERT INTO shops(zipcode) VALUES (?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, o.getZipcode());
        stmt.execute();
        stmt.close();
    }

    @Override
    public void update(Connection conn, Shop o, int id) throws SQLException {
        String sql = "UPDATE shops SET zipcode = ? WHERE id_shop = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, o.getZipcode());
        stmt.execute();
        stmt.close();
    }

    @Override
    public void delete(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM shops WHERE id_shop = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
    }
}
