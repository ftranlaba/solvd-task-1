package sql.dao.entity.country;

import sql.datamodels.entity.City;
import sql.datamodels.entity.Country;
import sql.datamodels.person.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class CountryDaoMysql implements ICountryDao{

    @Override
    public Optional get(Connection conn, int id) throws SQLException {
        //public Country(String name)
        String sql = "SELECT name FROM countries WHERE id_country = ?";
        return Optional.ofNullable(new Country(genericGet(conn, sql, id)));
    }

    @Override
    public List getAll(Connection conn) throws SQLException{
        //public Country(String name)
        String sql = "SELECT name FROM countries";
        List<Object[]> list = genericGet(conn, sql);
        List<Country> output = new ArrayList<>();
        for(Object[] o : list){
            output.add(new Country(o));
        }
        return output;
    }

    @Override
    public void save(Connection conn, Country o) throws SQLException{
        String sql = "INSERT INTO countries(name) VALUES (?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, o.getName());
        stmt.execute();
        stmt.close();
    }

    @Override
    public void update(Connection conn, Country o, int id) throws SQLException{
        String sql = "UPDATE countries SET name = ? WHERE id_country = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, o.getName());
        stmt.setInt(2, id);
        stmt.execute();
        stmt.close();
    }

    @Override
    public void delete(Connection conn, int id) throws SQLException{
        String sql = "DELETE FROM countries WHERE id_country = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
    }
}
