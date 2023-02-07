package sql.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sql.dao.IBaseDAO;

import java.util.List;
import java.util.Optional;

public class MyBatisDAO<T> {
    protected static final Logger LOGGER = LogManager.getLogger("TESTLOGGER");
    protected SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();
    private IBaseDAO objDAO;

    protected Optional get(int id, Class classInfo) {
        Optional output = null;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            objDAO = (IBaseDAO) sqlSession.getMapper(classInfo);
            output = objDAO.get(id);
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return output;
    }

    protected List getAll(Class classInfo) {
        List list = null;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            objDAO = (IBaseDAO) sqlSession.getMapper(classInfo);
            list = objDAO.getAll();
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return list;
    }

    protected void save(T o, Class classInfo) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            objDAO = (IBaseDAO) sqlSession.getMapper(classInfo);
            objDAO.save(o);
            sqlSession.commit();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    protected void update(T o, int id, Class classInfo) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            objDAO = (IBaseDAO) sqlSession.getMapper(classInfo);
            objDAO.update(o, id);
            sqlSession.commit();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    protected void delete(int id, Class classInfo) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            objDAO = (IBaseDAO) sqlSession.getMapper(classInfo);
            objDAO.delete(id);
            sqlSession.commit();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }
}
