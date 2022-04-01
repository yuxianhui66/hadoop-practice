package thread;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author yuxianhui
 * @create 2019-11-08 14:41
 **/
public class ConcurrentModificationExceptionTest {
    public static void main(String[] args)  {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer integer = iterator.next();
            if(integer==2)
              //  list.remove(integer);
                iterator.remove();
        }
    }
}
