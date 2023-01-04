package sql.dao.entity.country;

import sql.dao.IDao;
import sql.datamodels.entity.Country;

import java.util.List;
import java.util.Optional;

public interface ICountryDao extends IDao<Country> {
    Optional<Country> get(int id);

    List<Country> getAll();

    void save(Country o);

    void update(Country o, int id);

    void delete(int id);
}
