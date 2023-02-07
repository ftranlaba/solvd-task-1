package sql.dao.mybatis;

import sql.dao.IShopDAO;
import sql.datamodels.entity.Shop;

import java.util.List;
import java.util.Optional;

public class ShopDAO extends MyBatisDAO implements IShopDAO {
    private static final Class classReference = IShopDAO.class;

    @Override
    public Optional get(int id) {
        return get(id, classReference);
    }

    @Override
    public List getAll() {
        return getAll(classReference);
    }

    @Override
    public void save(Shop o) {
        save(o, classReference);
    }

    @Override
    public void update(Shop o, int id) {
        update(o, id, classReference);
    }

    @Override
    public void delete(int id) {
        delete(id, classReference);
    }
}