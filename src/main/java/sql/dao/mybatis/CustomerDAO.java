package sql.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import sql.dao.ICustomerDAO;
import sql.datamodels.person.Customer;

import java.util.List;
import java.util.Optional;

public class CustomerDAO extends MyBatisDAO implements ICustomerDAO {

    @Override
    public Optional get(int id) {
        Optional output = null;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICustomerDAO customerDAO = sqlSession.getMapper(ICustomerDAO.class);
            output = customerDAO.get(id);
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return output;
    }

    @Override
    public List getAll() {
        List<Customer> output = null;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICustomerDAO customerDAO = sqlSession.getMapper(ICustomerDAO.class);
            output = customerDAO.getAll();
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return output;
    }

    @Override
    public void save(Customer o) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICustomerDAO customerDAO = sqlSession.getMapper(ICustomerDAO.class);
            customerDAO.save(o);
            sqlSession.commit();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void savePhone(Customer o) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICustomerDAO customerDAO = sqlSession.getMapper(ICustomerDAO.class);
            customerDAO.savePhone(o);
            sqlSession.commit();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }


    @Override
    public void update(Customer o, int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICustomerDAO customerDAO = sqlSession.getMapper(ICustomerDAO.class);
            customerDAO.update(o, id);
            sqlSession.commit();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void updatePhone(Customer o, int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICustomerDAO customerDAO = sqlSession.getMapper(ICustomerDAO.class);
            customerDAO.updatePhone(o, id);
            sqlSession.commit();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void delete(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICustomerDAO customerDAO = sqlSession.getMapper(ICustomerDAO.class);
            customerDAO.delete(id);
            sqlSession.commit();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void deletePhone(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICustomerDAO customerDAO = sqlSession.getMapper(ICustomerDAO.class);
            customerDAO.deletePhone(id);
            sqlSession.commit();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }
}
