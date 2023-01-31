package sql.dao.mybatis;

import sql.dao.ICustomerDAO;
import sql.datamodels.person.Customer;

public interface ICustomerDAOMyBatis extends ICustomerDAO {
    void deletePhone(int id);

    void updatePhone(Customer o, int id);

    void savePhone(Customer o);
}
