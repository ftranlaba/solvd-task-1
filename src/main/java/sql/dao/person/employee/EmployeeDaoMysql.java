package sql.dao.person.employee;

import sql.datamodels.person.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class EmployeeDaoMysql implements IEmployeeDao {

    @Override
    public Optional get(Connection conn, int id) throws SQLException {
        //public Employee(String firstName, String lastName, String address, String phoneType, String phoneNumber, int zipcode)
        String sql = "SELECT first_name, last_name, address, phone_type, phone_number, zipcode " +
                "FROM employees INNER JOIN employee_phonenumbers ON employees.id_employee = employee_phonenumbers.id_employee WHERE id_employee = ?";
        return Optional.ofNullable(new Employee(genericGet(conn, sql, id)));
    }

    @Override
    public List getAll(Connection conn) throws SQLException{
        //public Customer(String firstName, String lastName, String address, String phoneType, String phoneNumber, int zipcode)
        String sql = "SELECT first_name, last_name, address, phone_type, phone_number, zipcode " +
                "FROM employees INNER JOIN employee_phonenumbers ON employees.id_employee = employee_phonenumbers.id_employee";
        List<Object[]> list = genericGet(conn, sql);
        List<Employee> output = new ArrayList<>();
        for(Object[] o : list){
            output.add(new Employee(o));
        }
        return output;
    }

    @Override
    public void save(Connection conn, Employee o) throws SQLException{
        String sql = "INSERT INTO employees(first_name, last_name, street, zipcode) VALUES (?, ?, ?, ?)";
        String phonesql = "INSERT INTO employee_phonenumbers(phone_type, phone_number) VALUES(?, ?)";
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
    public void update(Connection conn, Employee o, int id) throws SQLException{
        String sql = "UPDATE employees SET first_name = ?, last_name = ?, street = ?, zipcode = ? WHERE id_employee = ?";
        String phonesql = "UPDATE employee_phonenumbers SET phone_type = ?, phone_number = ? WHERE id_employee = ?";

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
    public void delete(Connection conn, int id) throws SQLException{
        String sql = "DELETE FROM employees WHERE id_employee = ?";
        String phonesql = "DELETE FROM employee_phonenumbers WHERE id_employee = ?";

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
