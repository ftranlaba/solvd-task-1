package sql.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IBaseDAO<T> {

    Optional<T> get(int id);

    List<T> getAll();

    void save(T o);

    void update(T o, int id);

    void delete(int id);


}