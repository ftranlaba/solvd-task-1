package sql.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import sql.dao.ICustomerDAO;
import sql.datamodels.person.Customer;

import java.util.List;
import java.util.Optional;

public class CustomerDAO extends MyBatisDAO implements ICustomerDAOMyBatis {
    private static final Class classReference = ICustomerDAOMyBatis.class;

    @Override
    public Optional get(int id) {
        return get(id, classReference);
    }

    @Override
    public List getAll() {
        return getAll(classReference);
    }

    @Override
    public void save(Customer o) {
        save(o, classReference);
    }

    @Override
    public void savePhone(Customer o) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICustomerDAO customerDAO = sqlSession.getMapper(ICustomerDAOMyBatis.class);
            ((ICustomerDAOMyBatis) customerDAO).savePhone(o);
            sqlSession.commit();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }


    @Override
    public void update(Customer o, int id) {
        update(o, id, classReference);
    }

    @Override
    public void updatePhone(Customer o, int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICustomerDAO customerDAO = sqlSession.getMapper(ICustomerDAOMyBatis.class);
            ((ICustomerDAOMyBatis) customerDAO).updatePhone(o, id);
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
            ICustomerDAO customerDAO = sqlSession.getMapper(ICustomerDAOMyBatis.class);
            ((ICustomerDAOMyBatis) customerDAO).deletePhone(id);
            sqlSession.commit();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }
}
