package sql.dao.util;

import sql.dao.IBaseDAO;

public interface IDAOFactory {

    IBaseDAO getDAO(String modal);

}
