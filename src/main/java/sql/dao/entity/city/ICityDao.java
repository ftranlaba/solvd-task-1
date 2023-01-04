package sql.dao.entity.city;

import sql.dao.IDao;
import sql.datamodels.entity.City;

import java.util.List;
import java.util.Optional;

public interface ICityDao extends IDao<City> {
    Optional<City> get(int id);

    List<City> getAll();

    void save(City o);

    void update(City o, int id);

    void delete(int id);
}
