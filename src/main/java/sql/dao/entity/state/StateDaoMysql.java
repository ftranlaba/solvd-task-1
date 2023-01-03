package sql.dao.entity.state;


import sql.datamodels.entity.State;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class StateDaoMysql implements IStateDao {

    @Override
    public Optional get(Connection conn, int id) throws SQLException {
        //public State(String name)
        String sql = "SELECT name FROM states WHERE id_state = ?";
        return Optional.ofNullable(new State(genericGet(conn, sql, id)));
    }

    @Override
    public List getAll(Connection conn) throws SQLException{
        //public State(String name)
        String sql = "SELECT name FROM states";
        List<Object[]> list = genericGet(conn, sql);
        List<State> output = new ArrayList<>();
        for(Object[] o : list){
            output.add(new State(o));
        }
        return output;
    }

    @Override
    public void save(Connection conn, State o) throws SQLException{
        String sql = "INSERT INTO states(name) VALUES (?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, o.getName());
        stmt.execute();
        stmt.close();
    }

    @Override
    public void update(Connection conn, State o, int id) throws SQLException{
        String sql = "UPDATE states SET name = ? WHERE id_state = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, o.getName());
        stmt.setInt(2, id);
        stmt.execute();
        stmt.close();
    }

    @Override
    public void delete(Connection conn, int id) throws SQLException{
        String sql = "DELETE FROM states WHERE id_state = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
    }
}
