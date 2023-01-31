package sql.dao;

import sql.datamodels.person.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeDAO extends IPersonDAO<Employee> {
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

    @Override
    void deletePhone(int id);

    @Override
    void updatePhone(Employee o, int id);

    @Override
    void savePhone(Employee o);
}
