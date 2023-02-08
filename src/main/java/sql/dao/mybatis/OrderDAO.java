package sql.dao.mybatis;

import sql.dao.IOrderDAO;
import sql.datamodels.entity.Order;

import java.util.List;
import java.util.Optional;

public class OrderDAO extends MyBatisDAO implements IOrderDAO {
    private static final Class classReference = IOrderDAO.class;

    @Override
    public Optional get(int id) {
        return get(id, classReference);
    }

    @Override
    public List getAll() {
        return getAll(classReference);
    }

    @Override
    public void save(Order o) {
        save(o, classReference);
    }

    @Override
    public void update(Order o, int id) {
        update(o, id, classReference);
    }

    @Override
    public void delete(int id) {
        delete(id, classReference);
    }
}
