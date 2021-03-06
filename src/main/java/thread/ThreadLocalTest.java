package thread;

/**
 * @author yuxianhui
 * @create 2019-11-08 10:28
 **/
public class ThreadLocalTest {
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();
    long i = 0;
    long j = 0;

    public void set() {
   //     longLocal.set(Thread.currentThread().getId());
   //     stringLocal.set(Thread.currentThread().getName());
        longLocal.set(i++);
        stringLocal.set(Thread.currentThread().getName()+j++);
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadLocalTest test = new ThreadLocalTest();


        test.set();
        System.out.println(test.getLong());
        System.out.println(test.getString());
        test.set();
        System.out.println(test.getLong());
        System.out.println(test.getString());


        Thread thread1 = new Thread(){
            public void run() {
                test.set();
                System.out.println(test.getLong());
                System.out.println(test.getString());
            };
        };
        thread1.start();
        thread1.join();

        System.out.println(test.getLong());
        System.out.println(test.getString());
    }
}
