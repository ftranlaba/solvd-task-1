package sql.dao;

import sql.datamodels.entity.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface IManufacturerDAO extends IBaseDAO<Manufacturer> {
    Optional<Manufacturer> get(int id);

    List<Manufacturer> getAll();

    void save(Manufacturer o);

    void update(Manufacturer o, int id);

    void delete(int id);
}
