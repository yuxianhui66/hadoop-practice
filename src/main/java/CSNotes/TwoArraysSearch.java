package CSNotes;

/**
 * @author: xianhui.yu
 * @create: 2022-01-20 13:24
 **/
//给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
//
//        ```html
//        Consider the following matrix:
//        [
//        [1,   4,  7, 11, 15],
//        [2,   5,  8, 12, 19],
//        [3,   6,  9, 16, 22],
//        [10, 13, 14, 17, 24],
//        [18, 21, 23, 26, 30]
//        ]
//
//        Given target = 5, return true.
//        Given target = 20, return false.
//        ```
//
//        ## 解题思路
//
//        要求时间复杂度 O(M + N)，空间复杂度 O(1)。其中 M 为行数，N 为 列数。
public class TwoArraysSearch {
    public static void main(String[] args) {
        int[][] arrs = new int[][]
                {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        int num = 25;
        System.out.println(TwoArraysSearch(arrs,num));

    }

    private static boolean TwoArraysSearch(int[][] arrs, int num) {
        int rowLength = arrs.length;
        int arrLength = arrs[0].length;
        int i = 0;
        int j = arrLength-1;
        while(i<rowLength&&j>=0){
            if (num == arrs[i][j]) {
                return true;
            }else if (num > arrs[i][j]) {
                i++;
            }else if (num < arrs[i][j]) {
                j--;
            }
        }
        return false;
    }
}
