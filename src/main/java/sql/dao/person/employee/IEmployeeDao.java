package sql.dao.person.employee;

import sql.dao.IDao;
import sql.datamodels.person.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeDao extends IDao<Employee> {
    @Override
    Optional get(int id);

    @Override
    List getAll();

    @Override
    void save(Employee o);

    @Override
    void update(Employee o, int id);

    @Override
    void delete(int id);
}
