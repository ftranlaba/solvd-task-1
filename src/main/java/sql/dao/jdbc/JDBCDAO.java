package sql.dao.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sql.connectionpool.JDBCConnectionPool;

import java.sql.*;
import java.util.*;

public abstract class JDBCDAO {
    private static final JDBCConnectionPool pool = JDBCConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger("TESTLOGGER");

    private JDBCConnectionPool getPool() {
        return pool;
    }

    public Map<String, List<Object>> resultSetToMap(ResultSet rs) throws SQLException {
        ResultSetMetaData meta = rs.getMetaData();
        int columnCount = meta.getColumnCount();
        Map<String, List<Object>> map = new LinkedHashMap<>();
        for (int i = 1; i <= columnCount; i++) {
            map.put(meta.getColumnName(i), new ArrayList<>());
        }
        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                map.get(meta.getColumnName(i)).add(rs.getObject(i));
            }
        }
        return map;
    }

    public Map<String, List<Object>> boilerPlateGet(Connection conn, String sql, int id) throws SQLException {
        ResultSet result = null;
        Map<String, List<Object>> map = null;
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        result = stmt.executeQuery();
        map = resultSetToMap(result);
        stmt.close();
        return map;
    }

    public Map<String, List<Object>> boilerPlateGet(Connection conn, String sql) throws SQLException {
        ResultSet result = null;
        Map<String, List<Object>> map = null;
        PreparedStatement stmt = conn.prepareStatement(sql);
        result = stmt.executeQuery();
        map = resultSetToMap(result);
        stmt.close();
        return map;
    }

    public Object[] getRowDataById(Connection conn, String sql, int id) throws SQLException {
        // each key in the map represents a column
        // each Object inside the List represents a row value of the column
        Map<String, List<Object>> map = boilerPlateGet(conn, sql, id);
        Object[] rowData = null;
        if (map != null) {
            rowData = new Object[map.size()];
            Iterator<List<Object>> iter = map.values().iterator();
            int i = 0;
            while (iter.hasNext()) {
                rowData[i] = iter.next().get(0);
                i++;
            }
        }
        // returns the desired row from the sql table as an Object[]
        return rowData;
    }

    public List<Object[]> getRowData(Connection conn, String sql) throws SQLException {
        // each key in the map represents a column
        // each object inside the List represents a row value of the column
        Map<String, List<Object>> map = boilerPlateGet(conn, sql);
        List<Object[]> output = new ArrayList<>();
        if (map != null) {
            int rowCount = map.values().stream().findAny().orElse(new ArrayList<>()).size();
            for (int listIndex = 0; listIndex < rowCount; listIndex++) {
                Object[] rowData = new Object[map.size()];
                Iterator<List<Object>> iter = map.values().iterator();
                int i = 0;
                while (iter.hasNext()) {
                    rowData[i] = iter.next().get(listIndex);
                    i++;
                }
                output.add(rowData.clone());
            }
        }
        // returns each row from the sql table as an Object[]. Each row is stored inside the List
        return output;
    }

    public Object[] getById(String sql, int id) {
        Connection conn = pool.getConnection();
        Object[] row = null;
        try {
            row = getRowDataById(conn, sql, id);
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            if (conn != null) {
                pool.returnConnection(conn);
            }
        }
        return row;
    }

    public List<Object[]> getAll(String sql) {
        Connection conn = pool.getConnection();
        List<Object[]> list = new ArrayList<>();
        try {
            list = getRowData(conn, sql);
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            if (conn != null) {
                pool.returnConnection(conn);
            }
        }
        return list;
    }

    public void save(String sql, List<Object> valueList, List<JDBCType> typeList) {
        Connection conn = pool.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            setStatementValue(stmt, valueList, typeList);
            stmt.execute();
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            if (conn != null) {
                pool.returnConnection(conn);
            }
        }
    }

    public void setStatementValue(PreparedStatement stmt, List<Object> valueList, List<JDBCType> typeList) throws SQLException {
        int i = 1;
        for (JDBCType enumObj : typeList) {
            switch (enumObj) {
                case INT:
                    stmt.setInt(i, (Integer) valueList.get(i - 1));
                    i++;
                    break;
                case STRING:
                    stmt.setString(i, "" + valueList.get(i - 1));
                    i++;
                    break;
                case TIMESTAMP:
                    stmt.setTimestamp(i, (Timestamp) valueList.get(i - 1));
                    i++;
                    break;
            }
        }
    }

    public void deleteById(String sql, int id) {
        Connection conn = pool.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            if (conn != null) {
                pool.returnConnection(conn);
            }
        }
    }
}