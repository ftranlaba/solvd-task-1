package sql.dao.entity.country;

import sql.dao.IDao;
import sql.datamodels.entity.Country;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ICountryDao extends IDao<Country> {
    Optional<Country> get(Connection conn, int id) throws SQLException;

    List<Country> getAll(Connection conn) throws SQLException;

    void save(Connection conn, Country o) throws SQLException;

    void update(Connection conn, Country o, int id) throws SQLException;

    void delete(Connection conn, int id) throws SQLException;
}
