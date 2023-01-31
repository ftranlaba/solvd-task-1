package sql.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import sql.dao.IStateDAO;
import sql.datamodels.entity.Product;
import sql.datamodels.entity.State;

import java.util.List;
import java.util.Optional;

public class StateDAO extends MyBatisDAO implements IStateDAO {

    @Override
    public Optional get(int id) {
        Optional output = null;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IStateDAO stateDAO = sqlSession.getMapper(IStateDAO.class);
            output = stateDAO.get(id);
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return output;
    }

    @Override
    public List getAll() {
        List<State> output = null;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IStateDAO stateDAO = sqlSession.getMapper(IStateDAO.class);
            output = stateDAO.getAll();
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return output;
    }

    @Override
    public void save(State o) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IStateDAO stateDAO = sqlSession.getMapper(IStateDAO.class);
            stateDAO.save(o);
            sqlSession.commit();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void update(State o, int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IStateDAO stateDAO = sqlSession.getMapper(IStateDAO.class);
            stateDAO.update(o, id);
            sqlSession.commit();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void delete(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IStateDAO stateDAO = sqlSession.getMapper(IStateDAO.class);
            stateDAO.delete(id);
            sqlSession.commit();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }
}