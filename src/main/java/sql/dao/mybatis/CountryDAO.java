package sql.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import sql.dao.ICountryDAO;
import sql.datamodels.entity.Country;

import java.util.List;
import java.util.Optional;

public class CountryDAO extends MyBatisDAO implements ICountryDAO {

    @Override
    public Optional get(int id) {
        Optional output = null;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICountryDAO countryDAO = sqlSession.getMapper(ICountryDAO.class);
            output = countryDAO.get(id);
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return output;
    }

    @Override
    public List getAll() {
        List<Country> output = null;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICountryDAO countryDAO = sqlSession.getMapper(ICountryDAO.class);
            output = countryDAO.getAll();
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return output;
    }

    @Override
    public void save(Country o) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICountryDAO countryDAO = sqlSession.getMapper(ICountryDAO.class);
            countryDAO.save(o);
            sqlSession.commit();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void update(Country o, int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICountryDAO countryDAO = sqlSession.getMapper(ICountryDAO.class);
            countryDAO.update(o, id);
            sqlSession.commit();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void delete(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ICountryDAO countryDAO = sqlSession.getMapper(ICountryDAO.class);
            countryDAO.delete(id);
            sqlSession.commit();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }
}
