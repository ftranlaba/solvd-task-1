package sql.dao.mybatis;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import sql.dao.ICustomerDAO;
import sql.dao.IEmployeeDAO;
import sql.dao.mysql.MySQLDAO;
import sql.dao.mysql.MySQLType;
import sql.datamodels.person.Customer;
import sql.datamodels.person.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeDAO extends MyBatisDAO implements IEmployeeDAO {

    @Override
    public Optional get(int id) {
        Optional output = null;
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
            output = employeeDAO.get(id);
        }
        catch(Exception e){
            LOGGER.error(e);
        }
        return output;
    }

    @Override
    public List getAll() {
        List<Employee> output = null;
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
            output = employeeDAO.getAll();
        }
        catch(Exception e){
            LOGGER.error(e);
        }
        return output;
    }

    @Override
    public void save(Employee o) {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
            employeeDAO.save(o);
            sqlSession.commit();
        }
        catch(Exception e){
            LOGGER.error(e);
        }
    }

    @Override
    public void savePhone(Employee o) {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
            employeeDAO.savePhone(o);
            sqlSession.commit();
        }
        catch(Exception e){
            LOGGER.error(e);
        }
    }


    @Override
    public void update(Employee o, int id) {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
            employeeDAO.update(o, id);
            sqlSession.commit();
        }
        catch(Exception e){
            LOGGER.error(e);
        }
    }

    @Override
    public void updatePhone(Employee o, int id) {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
            employeeDAO.updatePhone(o, id);
            sqlSession.commit();
        }
        catch(Exception e){
            LOGGER.error(e);
        }
    }

    @Override
    public void delete(int id) {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
            employeeDAO.delete(id);
            sqlSession.commit();
        }
        catch(Exception e){
            LOGGER.error(e);
        }
    }

    @Override
    public void deletePhone(int id) {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
            employeeDAO.deletePhone(id);
            sqlSession.commit();
        }
        catch(Exception e){
            LOGGER.error(e);
        }
    }
}
