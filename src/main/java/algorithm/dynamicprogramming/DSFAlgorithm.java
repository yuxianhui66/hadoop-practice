package algorithm.dynamicprogramming;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yuxianhui
 * @create 2021-03-03 16:27
 **/
public class DSFAlgorithm {
    List<List<Integer>> res = new LinkedList<>();

    //全排序
    @Test
    public void AllSort() {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素
    // 结束条件：nums 中的元素全都在 track 中出现
    void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i]))
                continue;
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }

    @Test
    public void AllSort2() {
        int[] nums = {1, 2, 3};
        System.out.println(permute2(nums));
    }

    private List<List<Integer>> permute2(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack2(nums, track);
        return res;
    }

    void backtrack2(int[] nums, LinkedList<Integer> track) {
        if (nums.length == track.size()) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backtrack2(nums, track);
            track.removeLast();
        }
    }

    //N皇后
    @Test
    public void solveNQueens() {
        System.out.println(solveNQueens(8));
        System.out.println(res1.size());
    }

    List<List<String>> res1 = new ArrayList<>();

    /* 输入棋盘边长 n，返回所有合法的放置 */
    List<List<String>> solveNQueens(int n) {
        // '.' 表示空，'Q' 表示皇后，初始化空棋盘。
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(board, 0);
        return res1;
    }


    // 路径：board 中小于 row 的那些行都已经成功放置了皇后
// 选择列表：第 row 行的所有列都是放置皇后的选择
// 结束条件：row 超过 board 的最后一行
    void backtrack(char[][] board, int row) {
        // 触发结束条件
        if (row == board.length) {
            res1.add(construct(board));
            return;
        }

        int n = board[row].length;
        for (int col = 0; col < n; col++) {
            // 排除不合法选择
            if (!isValid(board, row, col))
                continue;
            // 做选择
            board[row][col] = 'Q';
            // 进入下一行决策
            backtrack(board, row + 1);
            // 撤销选择
            board[row][col] = '.';
        }
    }

    //把数组转为list
    private List<String> construct(char[][] chess) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            path.add(new String(chess[i]));
        }
        return path;
    }

    /* 是否可以在 board[row][col] 放置皇后？ */
    boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        // 检查列是否有皇后互相冲突
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q')
                return false;
        }
        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }

    @Test
    public void subsets() {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); ++mask) {
            t.clear();
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            res2.add(new ArrayList<Integer>(t));
        }
        return res2;
    }

    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> res2 = new ArrayList<>();


    @Test
    public void diffWaysToCompute() {
        List<Integer> res = diffWaysToCompute("2*3-4*5");
        System.out.println(res);
    }

    List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // 扫描算式 input 中的运算符
            if (c == '-' || c == '*' || c == '+') {
                /****** 分 ******/
                // 以运算符为中心，分割成两个字符串，分别递归计算
                List<Integer>
                        left = diffWaysToCompute(input.substring(0, i));
                List<Integer>
                        right = diffWaysToCompute(input.substring(i + 1));
                /****** 治 ******/
                // 通过子问题的结果，合成原问题的结果
                for (int a : left)
                    for (int b : right)
                        if (c == '+')
                            res.add(a + b);
                        else if (c == '-')
                            res.add(a - b);
                        else if (c == '*')
                            res.add(a * b);
            }
        }
        // base case
        // 如果 res 为空，说明算式是一个数字，没有运算符
        if (res.isEmpty()) {
            res.add(Integer.parseInt(input));
        }
        return res;
    }

    //递归 斐波那契数列
    @Test
    public void fib() {
        System.out.println(fib(18));
        System.out.println(fib2(18));
        System.out.println(fib3(18));
    }

    private int fib(int i) {
        if (i < 1) return 0;
        int[] meno = new int[i + 1];
        Arrays.fill(meno, 0);
        return helper(meno, i);
    }

    private int fib2(int i) {
        if (i < 1) return 0;
        int[] meno = new int[i + 1];
        Arrays.fill(meno, 0);
        meno[1] = meno[2] = 1;
        for (int j = 3; j < meno.length; j++) {
            meno[j] = meno[j - 1] + meno[j - 2];
        }
        return meno[i];
    }

    private int fib3(int i) {
        if (i < 1) return 0;
        int curr = 1;
        int prev = 1;
        for (int j = 3; j <= i; j++) {
            int sum = curr + prev;
            prev = curr;
            curr = sum;
        }
        return curr;
    }

    private int helper(int[] meno, int i) {
        if (i == 1 | i == 2) {
            return 1;
        }
        if (meno[i] != 0) {
            return meno[i];
        }
        meno[i] = helper(meno, i - 1) + helper(meno, i - 2);
        return meno[i];
    }

    // 递归 凑零钱问题
    @Test
    public void coinChange() {
        List<Integer> coins = new ArrayList();
        coins.add(1);
        coins.add(2);
        coins.add(5);
        int amount = 13;
        System.out.println(coinChange(coins, amount));
        System.out.println(coinChange2(coins, amount));
    }

    private int coinChange(List<Integer> coins, int amount) {
        int[] meno = new int[amount + 1];
        Arrays.fill(meno, 0);
        return coinChange(meno, coins, amount);
    }

    private int coinChange(int[] meno, List<Integer> coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (meno[amount] != 0) return meno[amount];
        int res = Integer.MAX_VALUE;
        for (Integer coin : coins) {
            int subProblem = coinChange(meno, coins, amount - coin);
            if (subProblem == -1) continue;
            if (subProblem + 1 < res) res = subProblem + 1;
        }
        meno[amount] = res;
        return meno[amount];

    }


    private int coinChange2(List<Integer> coins, int amount) {
        int[] meno = new int[amount + 1];
        Arrays.fill(meno, amount + 1);
        meno[0] = 0;
        return coinChange2(meno, coins, amount);
    }

    private int coinChange2(int[] meno, List<Integer> coins, int amount) {
        for (int i = 0; i < meno.length; i++) {
            for (Integer coin : coins) {
                if (i - coin < 0) continue;
                if (meno[i] > 1 + meno[i - coin]) meno[i] = 1 + meno[i - coin];
            }
        }
        return meno[amount] == amount+1?-1:meno[amount];
    }

}
