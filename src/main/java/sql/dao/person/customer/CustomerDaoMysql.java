package sql.dao.person.customer;

import sql.dao.MysqlDao;
import sql.dao.MysqlType;
import sql.datamodels.person.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDaoMysql extends MysqlDao implements ICustomerDao {

    @Override
    public Optional get(int id) {
        //public Customer(String firstName, String lastName, String address, String phoneType, String phoneNumber, int zipcode)
        String sql = "SELECT first_name, last_name, address, phone_type, phone_number, zipcode " +
                "FROM customers INNER JOIN customer_phonenumbers ON customers.id_customer = customer_phonenumbers.id_customer WHERE id_customers = ?";
        return Optional.ofNullable(new Customer(getWithTryCatch(sql, id)));
    }

    @Override
    public List getAll() {
        //public Customer(String firstName, String lastName, String address, String phoneType, String phoneNumber, int zipcode)
        String sql = "SELECT first_name, last_name, address, phone_type, phone_number, zipcode " +
                "FROM customers INNER JOIN customer_phonenumbers ON customers.id_customer = customer_phonenumbers.id_customer";
        List<Object[]> list = getWithTryCatch(sql);
        List<Customer> output = new ArrayList<>();
        for (Object[] o : list) {
            output.add(new Customer(o));
        }
        return output;
    }

    @Override
    public void save(Customer o) {
        String sql = "INSERT INTO customers(first_name, last_name, street, zipcode) VALUES (?, ?, ?, ?)";
        String phonesql = "INSERT INTO customer_phonenumbers(phone_type, phone_number) VALUES(?, ?)";
        List<Object> valueList = new ArrayList<>();
        valueList.add(o.getFirstName());
        valueList.add(o.getLastName());
        valueList.add(o.getAddress());
        valueList.add(o.getZipcode());

        List<MysqlType> typeList = new ArrayList<>();
        typeList.add(MysqlType.STRING);
        typeList.add(MysqlType.STRING);
        typeList.add(MysqlType.STRING);
        typeList.add(MysqlType.INT);

        saveWithTryCatch(sql, valueList, typeList);

        valueList = new ArrayList<>();
        valueList.add(o.getPhoneType());
        valueList.add(o.getPhoneNumber());

        typeList = new ArrayList<>();
        typeList.add(MysqlType.STRING);
        typeList.add(MysqlType.STRING);

        saveWithTryCatch(phonesql, valueList, typeList);
    }

    @Override
    public void update(Customer o, int id) {
        String sql = "UPDATE customers SET first_name = ?, last_name = ?, street = ?, zipcode = ? WHERE id_customer = ?";
        String phonesql = "UPDATE customer_phonenumbers SET phone_type = ?, phone_number = ? WHERE id_customer = ?";

        List<Object> valueList = new ArrayList<>();
        valueList.add(o.getFirstName());
        valueList.add(o.getLastName());
        valueList.add(o.getAddress());
        valueList.add(o.getZipcode());
        valueList.add(id);

        List<MysqlType> typeList = new ArrayList<>();
        typeList.add(MysqlType.STRING);
        typeList.add(MysqlType.STRING);
        typeList.add(MysqlType.STRING);
        typeList.add(MysqlType.INT);
        typeList.add(MysqlType.INT);

        saveWithTryCatch(sql, valueList, typeList);

        valueList = new ArrayList<>();
        valueList.add(o.getPhoneType());
        valueList.add(o.getPhoneNumber());
        valueList.add(id);

        typeList = new ArrayList<>();
        typeList.add(MysqlType.STRING);
        typeList.add(MysqlType.STRING);
        typeList.add(MysqlType.INT);

        saveWithTryCatch(phonesql, valueList, typeList);

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM customers WHERE id_customer = ?";
        String phonesql = "DELETE FROM customer_phonenumbers WHERE id_customer = ?";

        deleteWithTryCatch(phonesql, id);
        deleteWithTryCatch(sql, id);

    }
}
