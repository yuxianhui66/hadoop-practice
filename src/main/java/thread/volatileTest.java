package thread;

/**
 * @author yuxianhui
 * @create 2019-11-07 15:52
 **/
public class volatileTest {
    public  int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final volatileTest test = new volatileTest();
        for(int i=0;i<1000;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        test.increase();
                };
            }.start();
        }

        while(Thread.activeCount()>1)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println(test.inc);
    }
}
