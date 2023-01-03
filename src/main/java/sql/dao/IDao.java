package sql.dao;

import java.sql.*;
import java.util.*;

public interface IDao<T> {

    Optional<T> get(Connection conn, int id) throws SQLException;

    List<T> getAll(Connection conn) throws SQLException;

    void save(Connection conn, T o) throws SQLException;

    void update(Connection conn, T o, int id) throws SQLException;

    void delete(Connection conn, int id) throws SQLException;

    default Map<String, List<Object>> resultSetToMap(ResultSet rs) throws SQLException {
        ResultSetMetaData meta = rs.getMetaData();
        int columnCount = meta.getColumnCount();
        Map<String, List<Object>> map = new HashMap<>();
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

    default Map<String, List<Object>> boilerPlateGet(Connection conn, String sql, int id) throws SQLException {
        ResultSet result = null;
        Map<String, List<Object>> map = null;
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        result = stmt.executeQuery();
        map = resultSetToMap(result);
        stmt.close();
        return map;
    }

    default Map<String, List<Object>> boilerPlateGet(Connection conn, String sql) throws SQLException {
        ResultSet result = null;
        Map<String, List<Object>> map = null;
        PreparedStatement stmt = conn.prepareStatement(sql);
        result = stmt.executeQuery();
        map = resultSetToMap(result);
        stmt.close();
        return map;
    }

    default Object[] genericGet(Connection conn, String sql, int id) throws SQLException {
        // each key in the map represents a column
        // each Object inside the List represents a row value of the column
        Map<String, List<Object>> map = boilerPlateGet(conn, sql);
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

    default List<Object[]> genericGet(Connection conn, String sql) throws SQLException {
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
}