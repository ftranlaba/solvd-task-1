package sql.dao.entity.city;

import sql.datamodels.entity.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CityDaoMysql implements ICityDao {

    @Override
    public Optional get(Connection conn, int id) throws SQLException {
        //public City(String name)
        String sql = "SELECT name FROM cities WHERE id_city = ?";
        return Optional.ofNullable(new City(genericGet(conn, sql, id)));
    }

    @Override
    public List getAll(Connection conn) throws SQLException {
        //public City(String name)
        String sql = "SELECT name FROM cities";
        List<Object[]> list = genericGet(conn, sql);
        List<City> output = new ArrayList<>();
        for (Object[] o : list) {
            output.add(new City(o));
        }
        return output;
    }

    @Override
    public void save(Connection conn, City o) throws SQLException {
        String sql = "INSERT INTO cities(name) VALUES (?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, o.getName());
        stmt.execute();
        stmt.close();
    }

    @Override
    public void update(Connection conn, City o, int id) throws SQLException {
        String sql = "UPDATE cities SET name = ? WHERE id_city = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, o.getName());
        stmt.setInt(2, id);
        stmt.execute();
        stmt.close();
    }

    @Override
    public void delete(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM cities WHERE id_city = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
    }
}
