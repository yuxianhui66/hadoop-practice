package thread;

import java.util.Vector;

/**
 * @author yuxianhui
 * @create 2019-11-08 12:02
 **/
public class VectorTest2 {
    static Vector<Integer> vector = new Vector<Integer>();
    public static void main(String[] args) throws InterruptedException {
        while(true) {
            for(int i=0;i<10;i++)
                vector.add(i);
            Thread thread1 = new Thread(){
                public void run() {
                    synchronized (VectorTest2.class) {   //进行额外的同步
                        for (int i = 0; i < vector.size(); i++)
                            vector.remove(i);
                    }
                    };
            };
            Thread thread2 = new Thread(){
                public void run() {
                    synchronized (VectorTest2.class) {   //进行额外的同步
                        for (int i = 0; i < vector.size(); i++)
                            vector.get(i);
                    }
                };
            };
            thread1.start();
            thread2.start();
            while(Thread.activeCount()>10)   {

            }
        }
    }
}
