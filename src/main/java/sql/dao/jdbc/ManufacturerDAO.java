package sql.dao.jdbc;

import sql.dao.IManufacturerDAO;
import sql.datamodels.entity.Manufacturer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ManufacturerDAO extends JDBCDAO implements IManufacturerDAO {

    @Override
    public Optional get(int id) {
        //public Manufacturer(String name, int year)
        String sql = "SELECT name, year FROM manufacturers WHERE id_manufacturer = ?";
        return Optional.ofNullable(new Manufacturer(getById(sql, id)));
    }

    @Override
    public List getAll() {
        //public Manufacturer(String name, int year)
        String sql = "SELECT name, year FROM manufacturers";
        List<Object[]> list = getAll(sql);
        List<Manufacturer> output = new ArrayList<>();
        for (Object[] o : list) {
            output.add(new Manufacturer(o));
        }
        return output;
    }

    @Override
    public void save(Manufacturer o) {
        String sql = "INSERT INTO manufacturers(name, year) VALUES (?, ?)";
        List<Object> valueList = new ArrayList<>();
        valueList.add(o.getName());
        valueList.add(o.getYear());

        List<JDBCType> typeList = new ArrayList<>();
        typeList.add(JDBCType.STRING);
        typeList.add(JDBCType.INT);

        save(sql, valueList, typeList);
    }

    @Override
    public void update(Manufacturer o, int id) {
        String sql = "UPDATE manufacturers SET name = ?, year = ? WHERE id_manufacturer = ?";
        List<Object> valueList = new ArrayList<>();
        valueList.add(o.getName());
        valueList.add(o.getYear());
        valueList.add(id);

        List<JDBCType> typeList = new ArrayList<>();
        typeList.add(JDBCType.STRING);
        typeList.add(JDBCType.INT);
        typeList.add(JDBCType.INT);

        save(sql, valueList, typeList);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM manufacturers WHERE id_manufacturer = ?";
        deleteById(sql, id);
    }
}
