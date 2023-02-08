package sql.dao.mybatis;

import sql.dao.IStateDAO;
import sql.datamodels.entity.State;

import java.util.List;
import java.util.Optional;

public class StateDAO extends MyBatisDAO implements IStateDAO {
    private static final Class classReference = IStateDAO.class;

    @Override
    public Optional get(int id) {
        return get(id, classReference);
    }

    @Override
    public List getAll() {
        return getAll(classReference);
    }

    @Override
    public void save(State o) {
        save(o, classReference);
    }

    @Override
    public void update(State o, int id) {
        update(o, id, classReference);
    }

    @Override
    public void delete(int id) {
        delete(id, classReference);
    }
}