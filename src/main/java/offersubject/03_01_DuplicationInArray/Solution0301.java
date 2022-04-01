
/**
 * solution0301
 *
 * @author Anonymous
 * @date 2021/06/18
 * @since 2019/10/27
 */

public class Solution0301 {
    /**
     * 查找数组中的重复元素
     * @param numbers 数组
     * @param length 数组长度
     * @param duplication duplication[0]存储重复元素
     * @return boolean
     */
    public static boolean duplicate(int[] numbers, int length, int[] duplication) {
        if (numbers == null || length < 1) {
            return false;
        }
        for (int e : numbers) {
            if (e >= length) {
                return false;
            }
        }

        for (int i = 0; i < length; ++i) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers, i, numbers[i]);
            }
        }

        return false;
    }

    private static void swap(int[] numbers, int i, int j) {
        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }

    public static void main(String[] args) {
        int[] numbers = {2,3,1,0,2,5,3};
        int[] duplication = new int[1];
        if(duplicate(numbers,numbers.length,duplication)){
            System.out.println(duplication[0]);
        }
    }
}