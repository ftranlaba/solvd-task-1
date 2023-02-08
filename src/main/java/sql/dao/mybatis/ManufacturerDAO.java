package sql.dao.mybatis;

import sql.dao.IManufacturerDAO;
import sql.datamodels.entity.Manufacturer;

import java.util.List;
import java.util.Optional;

public class ManufacturerDAO extends MyBatisDAO implements IManufacturerDAO {
    private static final Class classReference = IManufacturerDAO.class;

    @Override
    public Optional get(int id) {
        return get(id, classReference);
    }

    @Override
    public List getAll() {
        return getAll(classReference);
    }

    @Override
    public void save(Manufacturer o) {
        save(o, classReference);
    }

    @Override
    public void update(Manufacturer o, int id) {
        update(o, id, classReference);
    }

    @Override
    public void delete(int id) {
        delete(id, classReference);
    }
}
