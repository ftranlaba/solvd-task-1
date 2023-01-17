package sql.xml.XMLParser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenericXMLParser implements IXMLParser, AutoCloseable {
    private static final Logger LOGGER = LogManager.getLogger("TESTLOGGER");
    private FileReader fileReader;

    public GenericXMLParser(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public List<Class<?>> getAll() {
        List<Class<?>> output = new ArrayList<>();
        boolean isStart = false;
        boolean foundProperty = false;
        String potentialElement = "";
        Stack<Class<?>> objStack = new Stack<>();
        Stack<String> classElementNameStack = new Stack<>();
        while (true) {
            int i = getReaderIndex();
            if (i == -1) break;
            char c = (char) i;
            if (!foundProperty) {
                if (isStart && c == '>') {
                    if (!objStack.empty() && potentialElement.equalsIgnoreCase(classElementNameStack.peek())) {
                        classElementNameStack.pop();
                        output.add(objStack.pop());
                    } else if (isClassElement(potentialElement)) {
                        objStack.push(getClassFromElement(potentialElement));
                        classElementNameStack.push("/" + potentialElement);
                    } else if (!objStack.empty() && isClassProperty(potentialElement, objStack.peek())) {
                        foundProperty = true;
                    }
                    potentialElement = "";
                    isStart = false;
                } else if (isStart) {
                    potentialElement += c;
                } else if (c == '<') {
                    isStart = true;
                }
            } else {
                if (c == '/' && potentialElement.charAt(potentialElement.length() - 1) == '<') {
                    Method m = getClassMethod(potentialElement, objStack.peek());
                    try {
                        m.invoke(objStack.peek(), potentialElement);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        LOGGER.error(e);
                    } finally {
                        potentialElement = "";
                        foundProperty = false;
                    }
                } else {
                    potentialElement += c;
                }
            }
        }

        return output;
    }

    private int getReaderIndex() {
        int output = 0;
        try {
            output = fileReader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

    public boolean isClassProperty(String s, Class<?> obj) {
        return getClassMethod(s, obj) != null;
    }

    public Method getClassMethod(String s, Class<?> obj) {
        Method[] array = obj.getMethods();
        for (Method m : array) {
            if (m.getName().contains(s)) return m;
        }
        return null;
    }

    public boolean isClassElement(String s) {
        s = s.substring(0, 1).toUpperCase() + s.substring(1);
        try {
            Class<?> obj = Class.forName(getPackageName(s));
            if (obj.toGenericString().contains("abstract")) {
                return false;
            }
        } catch (ClassNotFoundException e) {
            LOGGER.error(e);
            return false;
        }
        return true;
    }

    public Class<?> getClassFromElement(String s) {
        Class<?> obj = null;
        s = s.substring(0, 1).toUpperCase() + s.substring(1);
        try {
            obj = Class.forName(getPackageName(s));
        } catch (ClassNotFoundException e) {
            LOGGER.error(e);

        }
        return obj;
    }

    public String getPackageName(String s) {
        if (s.equalsIgnoreCase("customer") || s.equalsIgnoreCase("employee"))
            return "sql.datamodels.person." + s;
        return "sql.datamodels.entity." + s;
    }

    @Override
    public void close() throws Exception {
        fileReader.close();
    }
}