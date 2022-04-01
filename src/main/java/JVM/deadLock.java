package JVM;

/**
 * @author yuxianhui
 * @create 2019-10-18 18:03
 **/
public class deadLock {
    public static void main(String[] args) {
        Object lock1 = new Object();
         Object lock2 = new Object();
         new Thread(() -> {
             synchronized (lock1) {
                 try {
                     Thread.sleep(1000);

                } catch (InterruptedException e) {
                     e.printStackTrace();

                }
                 synchronized (lock2) {
                     System.out.println("线程1结束运行");

                }
            }
        }).start();
         new Thread(() -> {
             synchronized (lock2) {
                 try {
                     Thread.sleep(1000);

                } catch (InterruptedException e) {
                     e.printStackTrace();

                }
                 synchronized (lock1) {
                     System.out.println("线程2结束运行");

                }
            }
        }).start();
    }
}
