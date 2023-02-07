package sql.dao.mybatis;

import sql.dao.ICityDAO;
import sql.datamodels.entity.City;

import java.util.List;
import java.util.Optional;

public class CityDAO extends MyBatisDAO implements ICityDAO {
    private static final Class classReference = ICityDAO.class;

    @Override
    public Optional get(int id) {
        return get(id, classReference);
    }

    @Override
    public List getAll() {
        return getAll(classReference);
    }

    @Override
    public void save(City o) {
        save(o, classReference);
    }

    @Override
    public void update(City o, int id) {
        update(o, id, classReference);
    }

    @Override
    public void delete(int id) {
        delete(id, classReference);
    }
}
