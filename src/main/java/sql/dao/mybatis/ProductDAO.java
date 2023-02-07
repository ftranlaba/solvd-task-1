package sql.dao.mybatis;

import sql.dao.IProductDAO;
import sql.datamodels.entity.Product;

import java.util.List;
import java.util.Optional;

public class ProductDAO extends MyBatisDAO implements IProductDAO {
    private static final Class classReference = IProductDAO.class;

    @Override
    public Optional get(int id) {
        return get(id, classReference);
    }

    @Override
    public List getAll() {
        return getAll(classReference);
    }

    @Override
    public void save(Product o) {
        save(o, classReference);
    }

    @Override
    public void update(Product o, int id) {
        update(o, id, classReference);
    }

    @Override
    public void delete(int id) {
        delete(id, classReference);
    }
}