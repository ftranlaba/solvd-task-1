package sql.dao.util;

import sql.dao.util.enums.DBConnectionType;
import sql.dao.util.exceptions.UnsupportedFactoryException;

public class DBFactoryGenerator {
    public static IDAOFactory getFactory(DBConnectionType connectionType){
        switch(connectionType){
            case JDBC:
                return new JDBCDAOFactory();
            case MYBATIS:
                return new MyBatisSqlFactory();
            default:
                throw new UnsupportedFactoryException("JDBC Factory Type not supported.");
        }
    }
}
