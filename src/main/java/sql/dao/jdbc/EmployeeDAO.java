package sql.dao.jdbc;

import sql.dao.IEmployeeDAO;
import sql.datamodels.person.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeDAO extends JDBCDAO implements IEmployeeDAO {

    @Override
    public Optional get(int id) {
        //public Employee(String firstName, String lastName, String address, String phoneType, String phoneNumber, int zipcode)
        String sql = "SELECT first_name, last_name, address, phone_type, phone_number, zipcode " +
                "FROM employees INNER JOIN employee_phonenumbers ON employees.id_employee = employee_phonenumbers.id_employee WHERE id_employee = ?";
        return Optional.ofNullable(new Employee(getById(sql, id)));
    }

    @Override
    public List getAll() {
        //public Customer(String firstName, String lastName, String address, String phoneType, String phoneNumber, int zipcode)
        String sql = "SELECT first_name, last_name, address, phone_type, phone_number, zipcode " +
                "FROM employees INNER JOIN employee_phonenumbers ON employees.id_employee = employee_phonenumbers.id_employee";
        List<Object[]> list = getAll(sql);
        List<Employee> output = new ArrayList<>();
        for (Object[] o : list) {
            output.add(new Employee(o));
        }
        return output;
    }

    @Override
    public void save(Employee o) {
        String sql = "INSERT INTO employees(first_name, last_name, street, zipcode) VALUES (?, ?, ?, ?)";
        String phonesql = "INSERT INTO employee_phonenumbers(phone_type, phone_number) VALUES(?, ?)";
        List<Object> valueList = new ArrayList<>();
        valueList.add(o.getFirstName());
        valueList.add(o.getLastName());
        valueList.add(o.getAddress());
        valueList.add(o.getZipcode());

        List<JDBCType> typeList = new ArrayList<>();
        typeList.add(JDBCType.STRING);
        typeList.add(JDBCType.STRING);
        typeList.add(JDBCType.STRING);
        typeList.add(JDBCType.INT);

        save(sql, valueList, typeList);

        valueList = new ArrayList<>();
        valueList.add(o.getPhoneType());
        valueList.add(o.getPhoneNumber());

        typeList = new ArrayList<>();
        typeList.add(JDBCType.STRING);
        typeList.add(JDBCType.STRING);

        save(phonesql, valueList, typeList);
    }

    @Override
    public void update(Employee o, int id) {
        String sql = "UPDATE employees SET first_name = ?, last_name = ?, street = ?, zipcode = ? WHERE id_employee = ?";
        String phonesql = "UPDATE employee_phonenumbers SET phone_type = ?, phone_number = ? WHERE id_employee = ?";

        List<Object> valueList = new ArrayList<>();
        valueList.add(o.getFirstName());
        valueList.add(o.getLastName());
        valueList.add(o.getAddress());
        valueList.add(o.getZipcode());
        valueList.add(id);

        List<JDBCType> typeList = new ArrayList<>();
        typeList.add(JDBCType.STRING);
        typeList.add(JDBCType.STRING);
        typeList.add(JDBCType.STRING);
        typeList.add(JDBCType.INT);
        typeList.add(JDBCType.INT);

        save(sql, valueList, typeList);

        valueList = new ArrayList<>();
        valueList.add(o.getPhoneType());
        valueList.add(o.getPhoneNumber());
        valueList.add(id);

        typeList = new ArrayList<>();
        typeList.add(JDBCType.STRING);
        typeList.add(JDBCType.STRING);
        typeList.add(JDBCType.INT);

        save(phonesql, valueList, typeList);

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM employees WHERE id_employee = ?";
        String phonesql = "DELETE FROM employee_phonenumbers WHERE id_employee = ?";

        deleteById(phonesql, id);
        deleteById(sql, id);

    }
}
