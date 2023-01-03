package sql.dao.entity.manufacturer;

import sql.datamodels.entity.Country;
import sql.datamodels.entity.Manufacturer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class ManufacturerDaoMysql implements IManufacturerDao {

    @Override
    public Optional get(Connection conn, int id) throws SQLException {
        //public Manufacturer(String name, int year)
        String sql = "SELECT name, year FROM manufacturers WHERE id_manufacturer = ?";
        return Optional.ofNullable(new Manufacturer(genericGet(conn, sql, id)));
    }

    @Override
    public List getAll(Connection conn) throws SQLException{
        //public Manufacturer(String name, int year)
        String sql = "SELECT name, year FROM manufacturers";
        List<Object[]> list = genericGet(conn, sql);
        List<Manufacturer> output = new ArrayList<>();
        for(Object[] o : list){
            output.add(new Manufacturer(o));
        }
        return output;
    }

    @Override
    public void save(Connection conn, Manufacturer o) throws SQLException{
        String sql = "INSERT INTO manufacturers(name, year) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, o.getName());
        stmt.setInt(2, o.getYear());
        stmt.execute();
        stmt.close();
    }

    @Override
    public void update(Connection conn, Manufacturer o, int id) throws SQLException{
        String sql = "UPDATE manufacturers SET name = ?, year = ? WHERE id_manufacturer = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, o.getName());
        stmt.setInt(2, id);
        stmt.execute();
        stmt.close();
    }

    @Override
    public void delete(Connection conn, int id) throws SQLException{
        String sql = "DELETE FROM manufacturers WHERE id_manufacturer = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
    }
}
