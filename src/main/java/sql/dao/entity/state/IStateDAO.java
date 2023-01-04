package sql.dao.entity.state;

import sql.dao.IBaseDAO;
import sql.datamodels.entity.State;

import java.util.List;
import java.util.Optional;

public interface IStateDAO extends IBaseDAO<State> {
    Optional<State> get(int id);

    List<State> getAll();

    void save(State o);

    void update(State o, int id);

    void delete(int id);
}
