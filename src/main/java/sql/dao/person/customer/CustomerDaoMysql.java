package sql.dao.person.customer;

import sql.datamodels.person.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDaoMysql implements ICustomerDao {

    @Override
    public Optional get(Connection conn, int id) throws SQLException {
        //public Customer(String firstName, String lastName, String address, String phoneType, String phoneNumber, int zipcode)
        String sql = "SELECT first_name, last_name, address, phone_type, phone_number, zipcode " +
                "FROM customers INNER JOIN customer_phonenumbers ON customers.id_customer = customer_phonenumbers.id_customer WHERE id_customers = ?";
        return Optional.ofNullable(new Customer(genericGet(conn, sql, id)));
    }

    @Override
    public List getAll(Connection conn) throws SQLException {
        //public Customer(String firstName, String lastName, String address, String phoneType, String phoneNumber, int zipcode)
        String sql = "SELECT first_name, last_name, address, phone_type, phone_number, zipcode " +
                "FROM customers INNER JOIN customer_phonenumbers ON customers.id_customer = customer_phonenumbers.id_customer";
        List<Object[]> list = genericGet(conn, sql);
        List<Customer> output = new ArrayList<>();
        for (Object[] o : list) {
            output.add(new Customer(o));
        }
        return output;
    }

    @Override
    public void save(Connection conn, Customer o) throws SQLException {
        String sql = "INSERT INTO customers(first_name, last_name, street, zipcode) VALUES (?, ?, ?, ?)";
        String phonesql = "INSERT INTO customer_phonenumbers(phone_type, phone_number) VALUES(?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, o.getFirstName());
        stmt.setString(2, o.getLastName());
        stmt.setString(3, o.getAddress());
        stmt.setInt(4, o.getZipcode());
        stmt.execute();
        stmt.close();

        stmt = conn.prepareStatement(phonesql);
        stmt.setString(1, o.getPhoneType());
        stmt.setString(2, o.getPhoneNumber());
        stmt.execute();
        stmt.close();
    }

    @Override
    public void update(Connection conn, Customer o, int id) throws SQLException {
        String sql = "UPDATE customers SET first_name = ?, last_name = ?, street = ?, zipcode = ? WHERE id_customer = ?";
        String phonesql = "UPDATE customer_phonenumbers SET phone_type = ?, phone_number = ? WHERE id_customer = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, o.getFirstName());
        stmt.setString(2, o.getLastName());
        stmt.setString(3, o.getAddress());
        stmt.setInt(4, o.getZipcode());
        stmt.setInt(5, id);
        stmt.execute();
        stmt.close();

        stmt = conn.prepareStatement(phonesql);
        stmt.setString(1, o.getPhoneType());
        stmt.setString(2, o.getPhoneNumber());
        stmt.setInt(3, id);
        stmt.execute();
        stmt.close();

    }

    @Override
    public void delete(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM customers WHERE id_customer = ?";
        String phonesql = "DELETE FROM customer_phonenumbers WHERE id_customer = ?";

        PreparedStatement stmt = conn.prepareStatement(phonesql);
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();

        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();

    }
}
