package sql.dao.mysql;

import sql.dao.IEmployeeDAO;
import sql.datamodels.person.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeDAO extends MySQLDAO implements IEmployeeDAO {

    @Override
    public Optional get(int id) {
        //public Employee(String firstName, String lastName, String address, String phoneType, String phoneNumber, int zipcode)
        String sql = "SELECT first_name, last_name, address, phone_type, phone_number, zipcode " +
                "FROM employees INNER JOIN employee_phonenumbers ON employees.id_employee = employee_phonenumbers.id_employee WHERE id_employee = ?";
        return Optional.ofNullable(new Employee(getWithTryCatch(sql, id)));
    }

    @Override
    public List getAll() {
        //public Customer(String firstName, String lastName, String address, String phoneType, String phoneNumber, int zipcode)
        String sql = "SELECT first_name, last_name, address, phone_type, phone_number, zipcode " +
                "FROM employees INNER JOIN employee_phonenumbers ON employees.id_employee = employee_phonenumbers.id_employee";
        List<Object[]> list = getWithTryCatch(sql);
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

        List<MySQLType> typeList = new ArrayList<>();
        typeList.add(MySQLType.STRING);
        typeList.add(MySQLType.STRING);
        typeList.add(MySQLType.STRING);
        typeList.add(MySQLType.INT);

        saveWithTryCatch(sql, valueList, typeList);

        valueList = new ArrayList<>();
        valueList.add(o.getPhoneType());
        valueList.add(o.getPhoneNumber());

        typeList = new ArrayList<>();
        typeList.add(MySQLType.STRING);
        typeList.add(MySQLType.STRING);

        saveWithTryCatch(phonesql, valueList, typeList);
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

        List<MySQLType> typeList = new ArrayList<>();
        typeList.add(MySQLType.STRING);
        typeList.add(MySQLType.STRING);
        typeList.add(MySQLType.STRING);
        typeList.add(MySQLType.INT);
        typeList.add(MySQLType.INT);

        saveWithTryCatch(sql, valueList, typeList);

        valueList = new ArrayList<>();
        valueList.add(o.getPhoneType());
        valueList.add(o.getPhoneNumber());
        valueList.add(id);

        typeList = new ArrayList<>();
        typeList.add(MySQLType.STRING);
        typeList.add(MySQLType.STRING);
        typeList.add(MySQLType.INT);

        saveWithTryCatch(phonesql, valueList, typeList);

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM employees WHERE id_employee = ?";
        String phonesql = "DELETE FROM employee_phonenumbers WHERE id_employee = ?";

        deleteWithTryCatch(phonesql, id);
        deleteWithTryCatch(sql, id);

    }

    @Override
    public void deletePhone(int id) {

    }

    @Override
    public void updatePhone(Employee o, int id) {

    }

    @Override
    public void savePhone(Employee o) {

    }
}
