

/**
 * @author Anonymous
 * @since 2019/12/7
 */

public class Solution42 {
    /**
     * 求连续子数组的最大和
     *
     * @param array 数组
     * @return 最大和
     */
    public static int FindGreatestSumOfSubArray(int[] array) {
        int n = array.length;
        int[] res = new int[n];
        res[0] = array[0];
        int max = res[0];
        for (int i = 1; i < n; ++i) {
            res[i] = res[i - 1] > 0 ? res[i - 1] + array[i] : array[i];
            max = Math.max(max, res[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(FindGreatestSumOfSubArray(array));
    }
}
