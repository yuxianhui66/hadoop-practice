package thread;

/**
 * @author yuxianhui
 * @create 2019-11-07 15:04
 **/
public class SynchnoizedTest {
    public static int i = 0;

    public static void write() {

        synchronized (SynchnoizedTest.class) {
        //    System.out.println("静态方法");
            for (int j = 0; j < 10000; j++) {
                i++;
            }
        }
    }

    public  void read() {
   //     System.out.println("非静态方法");
        for (int j = 0; j < 10000; j++) {
            i++;
     //       System.out.println("Thread.currentThread().getName():"+name+"------"+i);
        }
    }

    public static void main(String[] args) {
        final SynchnoizedTest test1 = new SynchnoizedTest();
        for(int j = 0; j < 100; j++){
            new Thread() {
                @Override
                public void run() {
                //    for (int j = 0; j < 1000; j++) {
                //        test1.i++;
                //        System.out.println("Thread.currentThread().getName():"+Thread.currentThread().getName()+"------"+test1.i);
                //    }
                       test1.read();
                }
            }.start();
        }


        for(int j = 0; j < 100; j++) {
            new Thread() {
                @Override
                public void run() {

                    write();
                }
            }.start();
        }
        System.out.println(Thread.currentThread().getName());
//        try {
//            Thread.currentThread().sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        while(Thread.activeCount()>1)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println(test1.i);
    }
}
