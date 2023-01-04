package sql.dao.entity.country;

import sql.dao.MysqlDao;
import sql.dao.MysqlType;
import sql.datamodels.entity.Country;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CountryDaoMysql extends MysqlDao implements ICountryDao {

    @Override
    public Optional get(int id) {
        //public Country(String name)
        String sql = "SELECT name FROM countries WHERE id_country = ?";
        return Optional.ofNullable(new Country(getWithTryCatch(sql, id)));
    }

    @Override
    public List getAll() {
        //public Country(String name)
        String sql = "SELECT name FROM countries";
        List<Object[]> list = getWithTryCatch(sql);
        List<Country> output = new ArrayList<>();
        for (Object[] o : list) {
            output.add(new Country(o));
        }
        return output;
    }

    @Override
    public void save(Country o) {
        String sql = "INSERT INTO countries(name) VALUES (?)";
        List<Object> valueList = new ArrayList<>();
        valueList.add(o.getName());

        List<MysqlType> typeList = new ArrayList<>();
        typeList.add(MysqlType.STRING);

        saveWithTryCatch(sql, valueList, typeList);
    }

    @Override
    public void update(Country o, int id) {
        String sql = "UPDATE countries SET name = ? WHERE id_country = ?";
        List<Object> valueList = new ArrayList<>();
        valueList.add(o.getName());
        valueList.add(id);

        List<MysqlType> typeList = new ArrayList<>();
        typeList.add(MysqlType.STRING);
        typeList.add(MysqlType.INT);

        saveWithTryCatch(sql, valueList, typeList);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM countries WHERE id_country = ?";
        deleteWithTryCatch(sql, id);
    }
}
