package sql.dao.entity.state;

import sql.dao.IDao;
import sql.datamodels.entity.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IStateDao extends IDao<State> {
    Optional<State> get(Connection conn, int id) throws SQLException;

    List<State> getAll(Connection conn) throws SQLException;

    void save(Connection conn, State o) throws SQLException;

    void update(Connection conn, State o, int id) throws SQLException;

    void delete(Connection conn, int id) throws SQLException;
}
