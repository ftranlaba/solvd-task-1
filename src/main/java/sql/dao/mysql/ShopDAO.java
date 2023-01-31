package sql.dao.mysql;

import sql.dao.IShopDAO;
import sql.datamodels.entity.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShopDAO extends MySQLDAO implements IShopDAO {

    @Override
    public Optional get(int id) {
        //public Shop(int zipcode)
        String sql = "SELECT zipcode FROM shops WHERE id_shop = ?";
        return Optional.ofNullable(new Shop(getWithTryCatch(sql, id)));
    }

    @Override
    public List getAll() {
        //public Shop(int zipcode)
        String sql = "SELECT zipcode FROM shops";
        List<Object[]> list = getWithTryCatch(sql);
        List<Shop> output = new ArrayList<>();
        for (Object[] o : list) {
            output.add(new Shop(o));
        }
        return output;
    }

    @Override
    public void save(Shop o) {
        String sql = "INSERT INTO shops(zipcode) VALUES (?)";
        List<Object> valueList = new ArrayList<>();
        valueList.add(o.getZipcode());

        List<MySQLType> typeList = new ArrayList<>();
        typeList.add(MySQLType.INT);

        saveWithTryCatch(sql, valueList, typeList);
    }

    @Override
    public void update(Shop o, int id) {
        String sql = "UPDATE shops SET zipcode = ? WHERE id_shop = ?";
        List<Object> valueList = new ArrayList<>();
        valueList.add(o.getZipcode());
        valueList.add(id);

        List<MySQLType> typeList = new ArrayList<>();
        typeList.add(MySQLType.INT);
        typeList.add(MySQLType.INT);

        saveWithTryCatch(sql, valueList, typeList);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM shops WHERE id_shop = ?";
        deleteWithTryCatch(sql, id);
    }
}
