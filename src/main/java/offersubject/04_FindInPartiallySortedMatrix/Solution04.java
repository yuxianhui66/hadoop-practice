import org.junit.Test;

/**
 * @author Anonymous
 * @since 2019/10/27
 */

public class Solution04 {
    /**
     * 二维数组中的查找
     * @param target 目标值
     * @param array 二维数组
     * @return boolean
     */
    public boolean find(int target, int[][] array) {
        if (array == null) {
            return false;
        }
        int rows = array.length;
        int columns = array[0].length;

        int i = rows - 1;
        int j = 0;
        while (i >= 0 && j < columns) {
            if (array[i][j] == target) {
                return true;
            }
            if (array[i][j] < target) {
                ++j;
            } else {
                --i;
            }
        }
        return false;
    }

    @Test
    public void test(){
        int target =5;
        int[][] array = {{1,2,3},{4,5,6},{7,9,12}};
        System.out.println(find(target, array));
    }
}