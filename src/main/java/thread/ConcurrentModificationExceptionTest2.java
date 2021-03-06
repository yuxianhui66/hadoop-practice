package thread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

/**
 * @author yuxianhui
 * @create 2019-11-08 14:46
 **/
public class ConcurrentModificationExceptionTest2 {
  //  static ArrayList<Integer> list = new ArrayList<Integer>();
    static Vector<Integer> list = new Vector<Integer>();
    public static void main(String[] args)  {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Thread thread1 = new Thread(){
            public void run() {
                Iterator<Integer> iterator = list.iterator();
                while(iterator.hasNext()){
                    Integer integer = iterator.next();
                    System.out.println(integer);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
        };
        Thread thread2 = new Thread(){
            public void run() {
                Iterator<Integer> iterator = list.iterator();
                while(iterator.hasNext()){
                    Integer integer = iterator.next();
                    if(integer==2)
                        iterator.remove();
                }
            };
        };
        thread1.start();
        thread2.start();
    }
}
