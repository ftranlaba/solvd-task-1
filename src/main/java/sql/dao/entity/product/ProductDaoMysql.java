package sql.dao.entity.product;

import sql.dao.MysqlDao;
import sql.dao.MysqlType;
import sql.datamodels.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDaoMysql extends MysqlDao implements IProductDao {

    @Override
    public Optional get(int id) {
        //public Product(String name, int price, int amount)
        String sql = "SELECT name, price, amount FROM products WHERE id_product = ?";
        return Optional.ofNullable(new Product(getWithTryCatch(sql, id)));
    }

    @Override
    public List getAll() {
        //public Product(String name, int price, int amount)
        String sql = "SELECT name, price, amount FROM products";
        List<Object[]> list = getWithTryCatch(sql);
        List<Product> output = new ArrayList<>();
        for (Object[] o : list) {
            output.add(new Product(o));
        }
        return output;
    }

    @Override
    public void save(Product o) {
        String sql = "INSERT INTO products(name, price, amount) VALUES (?, ?, ?)";

        List<Object> valueList = new ArrayList<>();
        valueList.add(o.getName());
        valueList.add(o.getPrice());
        valueList.add(o.getAmount());

        List<MysqlType> typeList = new ArrayList<>();
        typeList.add(MysqlType.STRING);
        typeList.add(MysqlType.INT);
        typeList.add(MysqlType.INT);

        saveWithTryCatch(sql, valueList, typeList);
    }

    @Override
    public void update(Product o, int id) {
        String sql = "UPDATE products SET name = ?, price = ?, amount = ? WHERE id_product = ?";
        List<Object> valueList = new ArrayList<>();
        valueList.add(o.getName());
        valueList.add(o.getPrice());
        valueList.add(o.getAmount());
        valueList.add(id);

        List<MysqlType> typeList = new ArrayList<>();
        typeList.add(MysqlType.STRING);
        typeList.add(MysqlType.INT);
        typeList.add(MysqlType.INT);
        typeList.add(MysqlType.INT);

        saveWithTryCatch(sql, valueList, typeList);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM products WHERE id_product = ?";
        deleteWithTryCatch(sql, id);
    }
}
