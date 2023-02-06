package sql.dao.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyBatisDAO {
    protected static final Logger LOGGER = LogManager.getLogger("TESTLOGGER");
    protected SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();
}
