package sql.dao.jdbc;

import sql.dao.ICountryDAO;
import sql.datamodels.entity.Country;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CountryDAO extends JDBCDAO implements ICountryDAO {

    @Override
    public Optional get(int id) {
        //public Country(String name)
        String sql = "SELECT name FROM countries WHERE id_country = ?";
        return Optional.ofNullable(new Country(getById(sql, id)));
    }

    @Override
    public List getAll() {
        //public Country(String name)
        String sql = "SELECT name FROM countries";
        List<Object[]> list = getAll(sql);
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

        List<JDBCType> typeList = new ArrayList<>();
        typeList.add(JDBCType.STRING);

        save(sql, valueList, typeList);
    }

    @Override
    public void update(Country o, int id) {
        String sql = "UPDATE countries SET name = ? WHERE id_country = ?";
        List<Object> valueList = new ArrayList<>();
        valueList.add(o.getName());
        valueList.add(id);

        List<JDBCType> typeList = new ArrayList<>();
        typeList.add(JDBCType.STRING);
        typeList.add(JDBCType.INT);

        save(sql, valueList, typeList);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM countries WHERE id_country = ?";
        deleteById(sql, id);
    }
}
