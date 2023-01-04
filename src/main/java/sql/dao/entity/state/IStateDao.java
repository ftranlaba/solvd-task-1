package sql.dao.entity.state;

import sql.dao.IDao;
import sql.datamodels.entity.State;

import java.util.List;
import java.util.Optional;

public interface IStateDao extends IDao<State> {
    Optional<State> get(int id);

    List<State> getAll();

    void save(State o);

    void update(State o, int id);

    void delete(int id);
}
