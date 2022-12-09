package datastructure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLinkedList {
    private static final Logger LOGGER = LogManager.getLogger("TESTLOGGER");

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        LOGGER.info("CHECKING EMPTY LINKED LIST");
        LOGGER.info(list.toString());
        LOGGER.info("ADDING ELEMENTS");
        list.add(1);
        list.add(2);
        list.add(3);
        LOGGER.info(list.toString());
        LOGGER.info("INSERTING INTEGER 21 AT POSITION 1");
        list.insert(21, 1);
        LOGGER.info(list.toString());
        LOGGER.info("INSERTING INTEGER 33 AT THE END");
        list.insert(33, 4);
        LOGGER.info(list.toString());
        LOGGER.info("REMOVE LAST ELEMENT");
        list.remove(4);
        LOGGER.info(list.toString());
        LOGGER.info("OUT OF BOUNDS CHECK: REMOVING 100th element");
        list.remove(100);
        LOGGER.info(list.toString());
        LOGGER.info("REMOVE INTEGER 21 OBJECT");
        Integer o = new Integer(21);
        list.remove(o);
        LOGGER.info(list.toString());
    }
}
