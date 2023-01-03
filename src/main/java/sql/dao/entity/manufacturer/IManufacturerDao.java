package sql.dao.entity.manufacturer;

import sql.dao.IDao;
import sql.datamodels.entity.Country;
import sql.datamodels.entity.Manufacturer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IManufacturerDao extends IDao<Manufacturer> {
    Optional<Manufacturer> get(Connection conn, int id) throws SQLException;

    List<Manufacturer> getAll(Connection conn) throws SQLException;

    void save(Connection conn, Manufacturer o) throws SQLException;

    void update(Connection conn, Manufacturer o, int id) throws SQLException;

    void delete(Connection conn, int id) throws SQLException;
}
