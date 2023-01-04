package sql.dao.entity.shop;

import sql.dao.IDao;
import sql.datamodels.entity.Shop;

import java.util.List;
import java.util.Optional;

public interface IShopDao extends IDao<Shop> {
    Optional<Shop> get(int id);

    List<Shop> getAll();

    void save(Shop o);

    void update(Shop o, int id);

    void delete(int id);
}
