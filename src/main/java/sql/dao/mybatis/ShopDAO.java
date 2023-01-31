package sql.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import sql.dao.IShopDAO;
import sql.datamodels.entity.Shop;

import java.util.List;
import java.util.Optional;

public class ShopDAO extends MyBatisDAO implements IShopDAO {

    @Override
    public Optional get(int id) {
        Optional output = null;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IShopDAO shopDAO = sqlSession.getMapper(IShopDAO.class);
            output = shopDAO.get(id);
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return output;
    }

    @Override
    public List getAll() {
        List<Shop> output = null;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IShopDAO shopDAO = sqlSession.getMapper(IShopDAO.class);
            output = shopDAO.getAll();
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return output;
    }

    @Override
    public void save(Shop o) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IShopDAO shopDAO = sqlSession.getMapper(IShopDAO.class);
            shopDAO.save(o);
            sqlSession.commit();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void update(Shop o, int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IShopDAO shopDAO = sqlSession.getMapper(IShopDAO.class);
            shopDAO.update(o, id);
            sqlSession.commit();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void delete(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IShopDAO shopDAO = sqlSession.getMapper(IShopDAO.class);
            shopDAO.delete(id);
            sqlSession.commit();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }
}