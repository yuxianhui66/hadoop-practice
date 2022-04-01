package thread;

import java.util.ArrayList;
import java.util.Vector;

/**
 * @author yuxianhui
 * @create 2019-11-08 12:00
 **/
public class VectorTest {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Vector<Integer> vector = new Vector<Integer>();
        long start = System.currentTimeMillis();
        for(int i=0;i<100000;i++)
            list.add(i);
        long end = System.currentTimeMillis();
        System.out.println("ArrayList进行100000次插入操作耗时："+(end-start)+"ms");
        start = System.currentTimeMillis();
        for(int i=0;i<100000;i++)
            vector.add(i);
        end = System.currentTimeMillis();
        System.out.println("Vector进行100000次插入操作耗时："+(end-start)+"ms");
    }
}
