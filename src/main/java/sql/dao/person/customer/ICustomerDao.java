package sql.dao.person.customer;

import sql.dao.IDao;
import sql.datamodels.person.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ICustomerDao extends IDao<Customer> {

    @Override
    Optional get(Connection conn, int id) throws SQLException;

    @Override
    List getAll(Connection conn) throws SQLException;

    @Override
    void save(Connection conn, Customer o) throws SQLException;

    @Override
    void update(Connection conn, Customer o, int id) throws SQLException;

    @Override
    void delete(Connection conn, int id) throws SQLException;
}
