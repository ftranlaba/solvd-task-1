package sql.dao;

import sql.dao.IBaseDAO;
import sql.datamodels.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductDAO extends IBaseDAO<Product> {
    Optional<Product> get(int id);

    List<Product> getAll();

    void save(Product o);

    void update(Product o, int id);

    void delete(int id);
}
