package sql.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IDao<T> {

    Optional<T> get(int id) throws SQLException;

    List<T> getAll() throws SQLException;

    void save(T o) throws SQLException;

    void update(T o, int id) throws SQLException;

    void delete(int id) throws SQLException;


}