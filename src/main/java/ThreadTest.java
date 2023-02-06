import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadTest {
    private static final String resourceOne = "RESOURCE 1";
    private static final String resourceTwo = "RESOURCE 2";
    private static final Logger LOGGER = LogManager.getLogger("TESTLOGGER");

    public static void main(String[] args) {
        Thread t1 = new Thread(new TestRunnable());
        Thread t2 = new Thread(new TestThread());
        t1.start();
        t2.start();
    }

    public static class TestRunnable implements Runnable {
        @Override
        public void run() {
            synchronized (resourceOne) {
                LOGGER.info("TestRunnable has locked resourceOne");
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                }
                synchronized (resourceTwo) {
                    LOGGER.info("TestRunnable has locked resourceTwo");
                }
            }
        }
    }

    public static class TestThread extends Thread {
        @Override
        public void run() {
            synchronized (resourceTwo) {
                LOGGER.info("TestThread has locked resourceTwo");
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                }
                synchronized (resourceOne) {
                    LOGGER.info("TestThread has locked resourceOne");
                }
            }
        }

    }

}
