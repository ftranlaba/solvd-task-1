package sql.dao.entity.order;

import sql.dao.MysqlDao;
import sql.dao.MysqlType;
import sql.datamodels.entity.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderDaoMysql extends MysqlDao implements IOrderDao {

    @Override
    public Optional get(int id) {
        //public Order(Timestamp startDate, Timestamp endDate)
        String sql = "SELECT start_date, end_date FROM orders WHERE id_order = ?";
        return Optional.ofNullable(new Order(getWithTryCatch(sql, id)));
    }

    @Override
    public List getAll() {
        //public Order(Timestamp startDate, Timestamp endDate)
        String sql = "SELECT start_date, end_date FROM orders";
        List<Object[]> list = getWithTryCatch(sql);
        List<Order> output = new ArrayList<>();
        for (Object[] o : list) {
            output.add(new Order(o));
        }
        return output;
    }

    @Override
    public void save(Order o) {
        String sql = "INSERT INTO orders(start_date, end_date) VALUES (?, ?)";
        List<Object> valueList = new ArrayList<>();
        valueList.add(o.getStartDate());
        valueList.add(o.getEndDate());

        List<MysqlType> typeList = new ArrayList<>();
        typeList.add(MysqlType.TIMESTAMP);
        typeList.add(MysqlType.TIMESTAMP);

        saveWithTryCatch(sql, valueList, typeList);
    }

    @Override
    public void update(Order o, int id) {
        String sql = "UPDATE orders SET start_date = ?, end_date = ? WHERE id_order = ?";
        List<Object> valueList = new ArrayList<>();
        valueList.add(o.getStartDate());
        valueList.add(o.getEndDate());
        valueList.add(id);

        List<MysqlType> typeList = new ArrayList<>();
        typeList.add(MysqlType.TIMESTAMP);
        typeList.add(MysqlType.TIMESTAMP);
        typeList.add(MysqlType.INT);
        saveWithTryCatch(sql, valueList, typeList);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM orders WHERE id_order = ?";
        deleteWithTryCatch(sql, id);
    }
}
