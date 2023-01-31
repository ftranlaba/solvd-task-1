package sql.dao.mysql;

import sql.dao.ICityDAO;
import sql.datamodels.entity.City;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CityDAO extends MySQLDAO implements ICityDAO {

    @Override
    public Optional get(int id) {
        //public City(String name)
        String sql = "SELECT name FROM cities WHERE id_city = ?";
        return Optional.ofNullable(new City(getWithTryCatch(sql, id)));
    }

    @Override
    public List getAll() {
        //public City(String name)
        String sql = "SELECT name FROM cities";
        List<Object[]> list = getWithTryCatch(sql);
        List<City> output = new ArrayList<>();
        for (Object[] o : list) {
            output.add(new City(o));
        }
        return output;
    }

    @Override
    public void save(City o) {
        String sql = "INSERT INTO cities(name) VALUES (?)";
        List<Object> valueList = new ArrayList<>();
        valueList.add(o.getName());

        List<MySQLType> typeList = new ArrayList<>();
        typeList.add(MySQLType.STRING);

        saveWithTryCatch(sql, valueList, typeList);
    }

    @Override
    public void update(City o, int id) {
        String sql = "UPDATE cities SET name = ? WHERE id_city = ?";
        List<Object> valueList = new ArrayList<>();
        valueList.add(o.getName());
        valueList.add(id);

        List<MySQLType> typeList = new ArrayList<>();
        typeList.add(MySQLType.STRING);
        typeList.add(MySQLType.INT);

        saveWithTryCatch(sql, valueList, typeList);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM cities WHERE id_city = ?";
        deleteWithTryCatch(sql, id);
    }
}
