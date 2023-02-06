package sql.dao;

import sql.datamodels.entity.Order;

import java.util.List;
import java.util.Optional;

public interface IOrderDAO extends IBaseDAO<Order> {
    Optional<Order> get(int id);

    List<Order> getAll();

    void save(Order o);

    void update(Order o, int id);

    void delete(int id);
}
