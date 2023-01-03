package sql.dao.entity.city;

import sql.dao.IDao;
import sql.datamodels.entity.City;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ICityDao extends IDao<City> {
    Optional<City> get(Connection conn, int id) throws SQLException;

    List<City> getAll(Connection conn) throws SQLException;

    void save(Connection conn, City o) throws SQLException;

    void update(Connection conn, City o, int id) throws SQLException;

    void delete(Connection conn, int id) throws SQLException;
}
