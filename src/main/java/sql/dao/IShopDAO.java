package sql.dao;

import sql.datamodels.entity.Shop;

import java.util.List;
import java.util.Optional;

public interface IShopDAO extends IBaseDAO<Shop> {
    Optional<Shop> get(int id);

    List<Shop> getAll();

    void save(Shop o);

    void update(Shop o, int id);

    void delete(int id);
}
