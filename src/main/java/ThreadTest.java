public class ThreadTest{
    private static final String resourceOne = "RESOURCE 1";
    private static final String resourceTwo = "RESOURCE 2";

    public static void print(Object o) {
        System.out.println(o);
    }

    public static class TestRunnable implements Runnable{

        @Override
        public void run() {
            synchronized (resourceOne){
                print("TestRunnable has locked resourceOne");
                try { Thread.sleep(500);} catch (Exception e) {}
                synchronized (resourceTwo){
                    print("TestRunnable has locked resourceTwo");
                }
            }
        }
    }

    public static class TestThread extends Thread{
        @Override
        public void run() {
            synchronized (resourceTwo){
                print("TestThread has locked resourceTwo");
                try { Thread.sleep(500);} catch (Exception e) {}
                synchronized (resourceOne){
                    print("TestThread has locked resourceOne");
                }
            }
        }

    }

    public static void main(String[] args){
        Thread t1 = new Thread(new TestRunnable());
        Thread t2 = new Thread(new TestThread());
        t1.start();
        t2.start();

    }

}
