package sql.dao.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyBatisDAO {
    protected SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();
    protected static final Logger LOGGER = LogManager.getLogger("TESTLOGGER");
}
