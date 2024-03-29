package sql.dao.jdbc;

import sql.dao.IShopDAO;
import sql.datamodels.entity.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShopDAO extends JDBCDAO implements IShopDAO {

    @Override
    public Optional get(int id) {
        //public Shop(int zipcode)
        String sql = "SELECT zipcode FROM shops WHERE id_shop = ?";
        return Optional.ofNullable(new Shop(getById(sql, id)));
    }

    @Override
    public List getAll() {
        //public Shop(int zipcode)
        String sql = "SELECT zipcode FROM shops";
        List<Object[]> list = getAll(sql);
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

        List<JDBCType> typeList = new ArrayList<>();
        typeList.add(JDBCType.INT);

        save(sql, valueList, typeList);
    }

    @Override
    public void update(Shop o, int id) {
        String sql = "UPDATE shops SET zipcode = ? WHERE id_shop = ?";
        List<Object> valueList = new ArrayList<>();
        valueList.add(o.getZipcode());
        valueList.add(id);

        List<JDBCType> typeList = new ArrayList<>();
        typeList.add(JDBCType.INT);
        typeList.add(JDBCType.INT);

        save(sql, valueList, typeList);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM shops WHERE id_shop = ?";
        deleteById(sql, id);
    }
}
