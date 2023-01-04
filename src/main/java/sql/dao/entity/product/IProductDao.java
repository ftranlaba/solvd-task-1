package sql.dao.entity.product;

import sql.dao.IDao;
import sql.datamodels.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductDao extends IDao<Product> {
    Optional<Product> get(int id);

    List<Product> getAll();

    void save(Product o);

    void update(Product o, int id);

    void delete(int id);
}
