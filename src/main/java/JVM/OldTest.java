package JVM;

/**
 * @author yuxianhui
 * @create 2019-10-18 16:31
 **/
public class OldTest {
    private static final int _1MB = 1024*1024;

    /**
     * 虚拟机参数设置：-XX:+UseParallelGC -XX:+PrintGCDetails -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
     * @param args
     */
    public static void main(String[] args) {
        byte[] a = new byte[8*_1MB];

    }
}
