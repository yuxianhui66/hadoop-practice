package algorithm.interview;

import org.junit.Test;

/**
 * @author yuxianhui
 * @create 2021-03-10 16:15
 **/
public class Interview {
    /**
     * 有一个长为n的数组A，求满足0≤a≤b<n的A[b]-A[a]的最大值。
     *
     * 给定数组A及它的大小n，请返回最大差值。
     *
     * 测试样例：
     * [10,5],2
     * 返回：0
     */
    @Test
    public void Max(){
        int[] A = {10,13,17};
        int n=3;
        System.out.println(Max(A,n));
    }
    private int Max(int[] A,int n){
        if(A==null||A.length<=2){
            return 0;
        }
        int result = 0;
        int currMin = A[0];
        for (int i=1;i<n;i++) {
            result = Math.max(result,A[i]-currMin);
            currMin = Math.min(currMin,A[i]);
        }
        return result;
    }
    /**
     * 在4x4的棋盘上摆满了黑白棋子，黑白两色的位置和数目随机其中左上角坐标为(1,1),右下角坐标为(4,4),现在依次有一些翻转操作，要对一些给定支点坐标为中心的上下左右四个棋子的颜色进行翻转，请计算出翻转后的棋盘颜色。
     *
     * 给定两个数组A和f,分别为初始棋盘和翻转位置。其中翻转位置共有3个。请返回翻转后的棋盘。
     *
     * 测试样例：
     * [[0,0,1,1],[1,0,1,0],[0,1,1,0],[0,0,1,0]],[[2,2],[3,3],[4,4]]
     * 返回：[[0,1,1,1],[0,0,1,0],[0,1,1,0],[0,0,1,0]]
     */
    @Test
    public void flipChess(){
//        "0 0 1 1"
//        "1 0 1 0"
//        "0 1 1 0"
//        "0 0 1 0"
//
//        "0 1 1 1"
//        "1 0 1 0"
//        "0 1 1 1"
//        "0 0 1 0"

        int[][] A = {{0,0,1,1},{1,0,1,0},{0,1,1,0},{0,0,1,0}};
        int[][] f = {{2,2},{3,3},{4,4}};
        System.out.println(flipChess(A,f));

    }
    public int[][] flipChess(int[][] A, int[][] f) {

        for(int i=0;i<f.length;i++){
            int row = f[i][0]-1;
            int col = f[i][1]-1;
            if(row-1>=0){
                A[row-1][col] = A[row-1][col]==0?1:0;
            }
            if(row+1<=3){
                A[row+1][col] = A[row-1][col]==0?1:0;
            }
            if(col-1>=0){
                A[row][col-1]= A[row][col-1]==0?1:0;
            }
            if(col+1<=3){
                A[row][col+1]= A[row][col+1]==0?1:0;
            }
        }
        return A;
    }
    /**
     * 较难
     * 现在有一个城市销售经理，需要从公司出发，去拜访市内的商家，已知他的位置以及商家的位置，但是由于城市道路交通的原因，他只能在左右中选择一个方向，在上下中选择一个方向，现在问他有多少种方案到达商家地址。
     *
     * 给定一个地图map及它的长宽n和m，其中1代表经理位置，2代表商家位置，-1代表不能经过的地区，0代表可以经过的地区，请返回方案数，保证一定存在合法路径。保证矩阵的长宽都小于等于10。
     *
     * 测试样例：
     * [[0,1,0],[2,0,0]],2,3
     * 返回：2
     */



    /**
     * 有一个直方图，用一个整数数组表示，其中每列的宽度为1，求所给直方图包含的最大矩形面积。比如，对于直方图[2,7,9,4],它所包含的最大矩形的面积为14(即[7,9]包涵的7x2的矩形)。
     *
     * 给定一个直方图A及它的总宽度n，请返回最大矩形面积。保证直方图宽度小于等于500。保证结果在int范围内。
     *
     * 测试样例：
     * [2,7,9,4,1],5
     * 返回：14
     */

}