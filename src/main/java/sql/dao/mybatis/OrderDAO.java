package sql.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import sql.dao.IOrderDAO;
import sql.datamodels.entity.Order;

import java.util.List;
import java.util.Optional;

public class OrderDAO extends MyBatisDAO implements IOrderDAO {

    @Override
    public Optional get(int id) {
        Optional output = null;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IOrderDAO orderDAO = sqlSession.getMapper(IOrderDAO.class);
            output = orderDAO.get(id);
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return output;
    }

    @Override
    public List getAll() {
        List<Order> output = null;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IOrderDAO orderDAO = sqlSession.getMapper(IOrderDAO.class);
            output = orderDAO.getAll();
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return output;
    }

    @Override
    public void save(Order o) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IOrderDAO orderDAO = sqlSession.getMapper(IOrderDAO.class);
            orderDAO.save(o);
            sqlSession.commit();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void update(Order o, int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IOrderDAO orderDAO = sqlSession.getMapper(IOrderDAO.class);
            orderDAO.update(o, id);
            sqlSession.commit();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void delete(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IOrderDAO orderDAO = sqlSession.getMapper(IOrderDAO.class);
            orderDAO.delete(id);
            sqlSession.commit();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }
}
