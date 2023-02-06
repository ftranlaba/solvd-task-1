package sql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sql.dao.IBaseDAO;
import sql.dao.util.DBFactoryGenerator;
import sql.dao.util.enums.DBConnectionType;

public class DAOUtilDriver {
    private static final Logger LOGGER = LogManager.getLogger("TESTLOGGER");
    public static void main(String[] args){
        IBaseDAO cityDAO = DBFactoryGenerator.getFactory(DBConnectionType.JDBC).getDAO("city");
        LOGGER.info(cityDAO.getAll());

        cityDAO = DBFactoryGenerator.getFactory(DBConnectionType.MYBATIS).getDAO("city");
        LOGGER.info(cityDAO.getAll());
    }
}
