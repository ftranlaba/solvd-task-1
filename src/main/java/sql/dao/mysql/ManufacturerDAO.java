package sql.dao.mysql;

import sql.dao.IManufacturerDAO;
import sql.datamodels.entity.Manufacturer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ManufacturerDAO extends MySQLDAO implements IManufacturerDAO {

    @Override
    public Optional get(int id) {
        //public Manufacturer(String name, int year)
        String sql = "SELECT name, year FROM manufacturers WHERE id_manufacturer = ?";
        return Optional.ofNullable(new Manufacturer(getWithTryCatch(sql, id)));
    }

    @Override
    public List getAll() {
        //public Manufacturer(String name, int year)
        String sql = "SELECT name, year FROM manufacturers";
        List<Object[]> list = getWithTryCatch(sql);
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

        List<MySQLType> typeList = new ArrayList<>();
        typeList.add(MySQLType.STRING);
        typeList.add(MySQLType.INT);

        saveWithTryCatch(sql, valueList, typeList);
    }

    @Override
    public void update(Manufacturer o, int id) {
        String sql = "UPDATE manufacturers SET name = ?, year = ? WHERE id_manufacturer = ?";
        List<Object> valueList = new ArrayList<>();
        valueList.add(o.getName());
        valueList.add(o.getYear());
        valueList.add(id);

        List<MySQLType> typeList = new ArrayList<>();
        typeList.add(MySQLType.STRING);
        typeList.add(MySQLType.INT);
        typeList.add(MySQLType.INT);

        saveWithTryCatch(sql, valueList, typeList);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM manufacturers WHERE id_manufacturer = ?";
        deleteWithTryCatch(sql, id);
    }
}
