package sql.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import sql.dao.ICityDAO;
import sql.dao.ICustomerDAO;
import sql.dao.mysql.MySQLDAO;
import sql.dao.mysql.MySQLType;
import sql.datamodels.entity.City;
import sql.datamodels.person.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CityDAO extends MyBatisDAO implements ICityDAO {

    @Override
    public Optional get(int id) {
        Optional output = null;
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            ICityDAO cityDAO = sqlSession.getMapper(ICityDAO.class);
            output = cityDAO.get(id);
        }
        catch(Exception e){
            LOGGER.error(e);
        }
        return output;
    }

    @Override
    public List getAll() {
        List<City> output = null;
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            ICityDAO cityDAO = sqlSession.getMapper(ICityDAO.class);
            output = cityDAO.getAll();
        }
        catch(Exception e){
            LOGGER.error(e);
        }
        return output;
    }

    @Override
    public void save(City o) {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            ICityDAO cityDAO = sqlSession.getMapper(ICityDAO.class);
            cityDAO.save(o);
            sqlSession.commit();
        }
        catch(Exception e){
            LOGGER.error(e);
        }
    }

    @Override
    public void update(City o, int id) {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            ICityDAO cityDAO = sqlSession.getMapper(ICityDAO.class);
            cityDAO.update(o, id);
            sqlSession.commit();
        }
        catch(Exception e){
            LOGGER.error(e);
        }
    }

    @Override
    public void delete(int id) {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            ICityDAO cityDAO = sqlSession.getMapper(ICityDAO.class);
            cityDAO.delete(id);
            sqlSession.commit();
        }
        catch(Exception e){
            LOGGER.error(e);
        }
    }
}
