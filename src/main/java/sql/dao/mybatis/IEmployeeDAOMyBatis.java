package sql.dao.mybatis;

import sql.dao.IEmployeeDAO;
import sql.datamodels.person.Employee;

public interface IEmployeeDAOMyBatis extends IEmployeeDAO {
    void deletePhone(int id);

    void updatePhone(Employee o, int id);

    void savePhone(Employee o);
}
