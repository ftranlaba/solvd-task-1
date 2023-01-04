package sql.dao.person.customer;

import sql.dao.IDao;
import sql.datamodels.person.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerDao extends IDao<Customer> {

    @Override
    Optional get(int id);

    @Override
    List getAll();

    @Override
    void save(Customer o);

    @Override
    void update(Customer o, int id);

    @Override
    void delete(int id);
}
