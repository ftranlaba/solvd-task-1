package sql.dao.person.employee;

import sql.dao.IDao;
import sql.datamodels.person.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IEmployeeDao extends IDao<Employee> {
    @Override
    Optional get(Connection conn, int id) throws SQLException;

    @Override
    List getAll(Connection conn) throws SQLException;

    @Override
    void save(Connection conn, Employee o) throws SQLException;

    @Override
    void update(Connection conn, Employee o, int id) throws SQLException;

    @Override
    void delete(Connection conn, int id) throws SQLException;
}
