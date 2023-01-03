package sql.connectionpool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class JDBCConnectionPool {
    private String url, user, pass;
    private ConcurrentMap<Connection, Boolean> map;
    private static final Logger LOGGER = LogManager.getLogger("TESTLOGGER");

    private JDBCConnectionPool(){
        this.url = "";
        this.user = "";
        this.pass = "";
        this.map = new ConcurrentHashMap<>();
    }

    public JDBCConnectionPool(String url, String user, String pass, int size) {
        this.url = url;
        this.user = user;
        this.pass = pass;
        this.map = new ConcurrentHashMap<>();
        createConnection(size);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Connection getConnection(){
        Connection output = map.keySet().stream()
                .filter(k -> !map.get(k))
                .findAny().orElse(null);
        if (output != null) {
            synchronized (output){
                if(!map.get(output))
                    map.put(output, true);
                else{
                    output = getConnection();
                }
            }
        }
        else{
            output = getConnection();
        }
        return output;
    }

    public void returnConnection(Connection o){
        map.put(o, false);
    }

    public void createConnection(){
        try {
            map.put(DriverManager.getConnection(url, user, pass), false);
        }
        catch(Exception e){
            LOGGER.error("SQL ERROR");
        }
    }

    public void createConnection(int size){
        for(int i = 0; i < size; i++){
            createConnection();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JDBCConnectionPool that = (JDBCConnectionPool) o;
        return Objects.equals(url, that.url) && Objects.equals(user, that.user) && Objects.equals(pass, that.pass) && Objects.equals(map, that.map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, user, pass, map);
    }

    @Override
    public String toString() {
        return "JDBCConnectionPool{" +
                "url='" + url + '\'' +
                ", user='" + user + '\'' +
                ", pass='" + pass + '\'' +
                ", map=" + map +
                '}';
    }
}
