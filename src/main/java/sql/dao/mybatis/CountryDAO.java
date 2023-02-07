package sql.dao.mybatis;

import sql.dao.ICountryDAO;
import sql.datamodels.entity.Country;

import java.util.List;
import java.util.Optional;

public class CountryDAO extends MyBatisDAO implements ICountryDAO {
    private static final Class classReference = ICountryDAO.class;

    @Override
    public Optional get(int id) {
        return get(id, classReference);
    }

    @Override
    public List getAll() {
        return getAll(classReference);
    }

    @Override
    public void save(Country o) {
        save(o, classReference);
    }

    @Override
    public void update(Country o, int id) {
        update(o, id, classReference);
    }

    @Override
    public void delete(int id) {
        delete(id, classReference);
    }
}
