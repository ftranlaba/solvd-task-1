package sql.dao;

import sql.datamodels.person.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerDAO extends IPersonDAO<Customer> {

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

    @Override
    void deletePhone(int id);

    @Override
    void updatePhone(Customer o, int id);

    @Override
    void savePhone(Customer o);
}
