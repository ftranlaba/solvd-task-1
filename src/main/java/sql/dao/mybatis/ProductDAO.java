package sql.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import sql.dao.IProductDAO;
import sql.dao.ICustomerDAO;
import sql.dao.mysql.MySQLDAO;
import sql.dao.mysql.MySQLType;
import sql.datamodels.entity.Order;
import sql.datamodels.entity.Product;
import sql.datamodels.person.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDAO extends MyBatisDAO implements IProductDAO {

    @Override
    public Optional get(int id) {
        Optional output = null;
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            IProductDAO productDAO = sqlSession.getMapper(IProductDAO.class);
            output = productDAO.get(id);
        }
        catch(Exception e){
            LOGGER.error(e);
        }
        return output;
    }

    @Override
    public List getAll() {
        List<Product> output = null;
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            IProductDAO productDAO = sqlSession.getMapper(IProductDAO.class);
            output = productDAO.getAll();
        }
        catch(Exception e){
            LOGGER.error(e);
        }
        return output;
    }

    @Override
    public void save(Product o) {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            IProductDAO productDAO = sqlSession.getMapper(IProductDAO.class);
            productDAO.save(o);
            sqlSession.commit();
        }
        catch(Exception e){
            LOGGER.error(e);
        }
    }

    @Override
    public void update(Product o, int id) {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            IProductDAO productDAO = sqlSession.getMapper(IProductDAO.class);
            productDAO.update(o, id);
            sqlSession.commit();
        }
        catch(Exception e){
            LOGGER.error(e);
        }
    }

    @Override
    public void delete(int id) {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            IProductDAO productDAO = sqlSession.getMapper(IProductDAO.class);
            productDAO.delete(id);
            sqlSession.commit();
        }
        catch(Exception e){
            LOGGER.error(e);
        }
    }
}