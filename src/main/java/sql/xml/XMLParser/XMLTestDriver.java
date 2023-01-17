package sql.xml.XMLParser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.util.List;

public class XMLTestDriver {
    private static final Logger LOGGER = LogManager.getLogger("TESTLOGGER");

    public static void main(String[] args) {
        String path = "src/main/resources/sql.xml";
        List<Class<?>> objList;
        try (GenericXMLParser parser = new GenericXMLParser(new FileReader(path))) {
            objList = parser.getAll();
            for (Class<?> o : objList) {
                System.out.println(o.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
