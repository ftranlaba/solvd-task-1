package sql.dao.entity.shop;

import sql.dao.IDao;
import sql.datamodels.entity.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IShopDao extends IDao<Shop> {
    Optional<Shop> get(Connection conn, int id) throws SQLException;

    List<Shop> getAll(Connection conn) throws SQLException;

    void save(Connection conn, Shop o) throws SQLException;

    void update(Connection conn, Shop o, int id) throws SQLException;

    void delete(Connection conn, int id) throws SQLException;
}
