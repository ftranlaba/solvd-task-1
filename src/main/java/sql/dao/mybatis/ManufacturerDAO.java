package sql.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import sql.dao.IManufacturerDAO;
import sql.dao.ICustomerDAO;
import sql.dao.mysql.MySQLDAO;
import sql.dao.mysql.MySQLType;
import sql.datamodels.entity.Manufacturer;
import sql.datamodels.person.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ManufacturerDAO extends MyBatisDAO implements IManufacturerDAO {

    @Override
    public Optional get(int id) {
        Optional output = null;
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            IManufacturerDAO manufacturerDAO = sqlSession.getMapper(IManufacturerDAO.class);
            output = manufacturerDAO.get(id);
        }
        catch(Exception e){
            LOGGER.error(e);
        }
        return output;
    }

    @Override
    public List getAll() {
        List<Manufacturer> output = null;
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            IManufacturerDAO manufacturerDAO = sqlSession.getMapper(IManufacturerDAO.class);
            output = manufacturerDAO.getAll();
        }
        catch(Exception e){
            LOGGER.error(e);
        }
        return output;
    }

    @Override
    public void save(Manufacturer o) {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            IManufacturerDAO manufacturerDAO = sqlSession.getMapper(IManufacturerDAO.class);
            manufacturerDAO.save(o);
            sqlSession.commit();
        }
        catch(Exception e){
            LOGGER.error(e);
        }
    }

    @Override
    public void update(Manufacturer o, int id) {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            IManufacturerDAO manufacturerDAO = sqlSession.getMapper(IManufacturerDAO.class);
            manufacturerDAO.update(o, id);
            sqlSession.commit();
        }
        catch(Exception e){
            LOGGER.error(e);
        }
    }

    @Override
    public void delete(int id) {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            IManufacturerDAO manufacturerDAO = sqlSession.getMapper(IManufacturerDAO.class);
            manufacturerDAO.delete(id);
            sqlSession.commit();
        }
        catch(Exception e){
            LOGGER.error(e);
        }
    }
}
