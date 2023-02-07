package sql.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import sql.dao.IEmployeeDAO;
import sql.datamodels.person.Employee;

import java.util.List;
import java.util.Optional;

public class EmployeeDAO extends MyBatisDAO implements IEmployeeDAOMyBatis {
    private static final Class classReference = IEmployeeDAOMyBatis.class;

    @Override
    public Optional get(int id) {
        return get(id, classReference);
    }

    @Override
    public List getAll() {
        return getAll(classReference);
    }

    @Override
    public void save(Employee o) {
        save(o, classReference);
    }

    @Override
    public void savePhone(Employee o) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAOMyBatis.class);
            ((IEmployeeDAOMyBatis) employeeDAO).savePhone(o);
            sqlSession.commit();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void update(Employee o, int id) {
        update(o, id, classReference);
    }

    @Override
    public void updatePhone(Employee o, int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAOMyBatis.class);
            ((IEmployeeDAOMyBatis) employeeDAO).updatePhone(o, id);
            sqlSession.commit();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void delete(int id) {
        delete(id, classReference);
    }

    @Override
    public void deletePhone(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAOMyBatis.class);
            ((IEmployeeDAOMyBatis) employeeDAO).deletePhone(id);
            sqlSession.commit();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }
}
