package sql.connectionpool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class JDBCConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger("TESTLOGGER");
    private static JDBCConnectionPool instance = null;
    private static Properties p = new Properties();

    static {
        try (FileInputStream f = new FileInputStream("src/main/resources/db.properties")) {
            p.load(f);
        } catch (IOException e) {
            LOGGER.info(e);
        }
    }

    private String url, user, pass;
    private ConcurrentMap<Connection, Boolean> map;

    private JDBCConnectionPool() {
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

    public static synchronized JDBCConnectionPool getInstance() {
        if (instance == null) {
            instance = new JDBCConnectionPool();
        }
        return instance;
    }

    public Connection getConnection() {
        Connection output = map.keySet().stream()
                .filter(k -> !map.get(k))
                .findAny().orElse(null);
        if (output != null) {
            synchronized (output) {
                if (!map.get(output))
                    map.put(output, true);
                else {
                    output = getConnection();
                }
            }
        } else {
            output = getConnection();
        }
        return output;
    }

    public void returnConnection(Connection o) {
        map.put(o, false);
    }

    public void createConnection() {
        try {
            map.put(DriverManager.getConnection(url, user, pass), false);
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    public void createConnection(int size) {
        for (int i = 0; i < size; i++) {
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
