package CSNotes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xianhui.yu
 * @create: 2022-01-20 15:24
 **/
//按顺时针的方向，从外到里打印矩阵的值。下图的矩阵打印结果为：1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10

public class PrintArray {
//    1  2  3  4
//    5  6  7  8
//    9  10 11 12
//    13 14 15 16
public static void main(String[] args) {
    String str="";
    int[][] arrs = new int[][]{
        {1,  2,  3,  4,18,30},
        {5,  6,  7,  8,19,31},
        {5,  6,  7,  8,19,32},
        {9,  10, 11, 12,20,33},
        {9,  10, 11, 12,20,33},
        {13, 14, 15, 16,21,34}};
    System.out.println(PrintArray(arrs));
    }
    private static List PrintArray(int[][] arrs) {
        int rowMin = 0;
        int rowMax = arrs.length-1;
        int colMin = 0;
        int colMax = arrs[0].length-1;
        List res = new ArrayList<>(arrs.length*arrs[0].length);
        while (rowMin <= rowMax&&colMin<=colMax) {
            //上
            for(int i=colMin;i<=colMax;i++){
              res.add(arrs[rowMin][i]);
            }
            //右
            for(int i =rowMin+1;i<=rowMax;i++){
                res.add(arrs[i][colMax]);
            }
            //下
            for(int j=colMax-1;j>=colMin;j--){
                res.add(arrs[rowMax][j]);
            }
            //左
            for(int j =rowMax-1;j>rowMin;j--){
                res.add(arrs[j][colMin]);
            }
            rowMin++;
            rowMax--;
            colMin++;
            colMax--;
        }
        return res;
    }
}
