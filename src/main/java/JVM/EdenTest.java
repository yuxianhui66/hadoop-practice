package JVM;

/**
 * @author yuxianhui
 * @create 2019-10-18 16:26
 **/
public class EdenTest {
    private static final int _1MB = 1024*1024;

    /**
     * 虚拟机参数设置：-XX:+UseParallelGC -XX:+PrintGCDetails -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
     * @param args
     */
    public static void main(String[] args) {
        byte[] a = new byte[2*_1MB];
        byte[] b = new byte[2*_1MB];
        byte[] c = new byte[2*_1MB];
        byte[] d = new byte[3*_1MB];
    }
}
