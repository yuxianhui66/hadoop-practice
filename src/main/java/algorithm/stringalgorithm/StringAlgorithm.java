package algorithm.stringalgorithm;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author yuxianhui
 * @create 2021-01-11 16:37
 **/
public class StringAlgorithm {
    /**
     * 最⻓公共前缀
     * Leetcode: 编写一个函数来查找字符串数组中的最⻓公共前缀。如果不存在公共前缀，返回空字符
     * 串 ""。 示例 1:
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 思路很简单!先利用Arrays.sort(strs)为数组排序，再将数组第一个元素和最后一个元素的字符从前 往后对比即可!
     */
    private static String replaceSpace(String[] strs) {
        boolean checkString = checkString(strs);
        if (!checkString) {
            return "";
        }
        Arrays.sort(strs);
        int m = strs[0].length();
        int n = strs[strs.length - 1].length();
        int min = Math.min(m, n);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < min; i++) {
            if (strs[0].charAt(i) != strs[strs.length - 1].charAt(i)) {
                break;
            }
            stringBuffer.append(strs[0].charAt(i));
        }
        return stringBuffer.toString();
    }

    private static boolean checkString(String[] strs) {
        boolean flag = true;
        if (strs == null) {
            return false;
        }
        for (String str : strs) {
            if (str == null || str.length() == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * 回文串 最⻓回文串
     * LeetCode: 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最⻓的回文 串。在构造过程中，请注意区分大小写。比如"Aa"不能当做一个回文字符串。注 意:假设字符串 的⻓度不会超过 1010。
     * 回文串:“回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。—— 百度百科 地址:https://baike.baidu.com/item/%E5%9B%9E%E6%96%87%E4%B8%B2/1274921?fr=alad din
     * 示例 1:
     * <p>
     * 输入: "abccccdd"
     * 输出: 7
     * 解释:
     * 我们可以构造的最⻓的回文串是"dccaccd", 它的⻓度是 7。
     * <p>
     * 我们上面已经知道了什么是回文串?现在我们考虑一下可以构成回文串的两种情况:
     * 字符出现次数为双数的组合 字符出现次数为双数的组合+一个只出现一次的字符
     * 统计字符出现的次数即可，双数才能构成回文。因为允许中间一个数单独出现，比如“abcba”，
     * 所以如 果最后有字母落单，总⻓度可以加 1。首先将字符串转变为字符数组。然后遍历该数组，
     * 判断对应字符 是否在hashset中，如果不在就加进去，如果在就让count++，
     * 然后移除该字符!这样就能找到出现次数 为双数的字符个数。
     */
    private static int longestPalindrome(String str) {
        if (str.length() == 0) {
            return 0;
        }
        HashSet hashSet = new HashSet();
        char[] chars = str.toCharArray();
        int count = 0;
        for (char aChar : chars) {
            if (hashSet.contains(aChar)) {
                count++;
                hashSet.remove(aChar);
            } else {
                hashSet.add(aChar);
            }
        }

        return hashSet.isEmpty() ? count * 2 : count * 2 + 1;

    }

    /**
     * 验证回文串
     * LeetCode: 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小 写。 说明:本题中，我们将空字符串定义为有效的回文串。
     * 示例 1:输入: "A man, a plan, a canal: Panama" 输出: true
     * 示例 2: 输入: "race a car" 输出: false
     */
    private static boolean isPalindrome(String str) {
        if (str.length() == 0) {
            return true;
        }
        int l = 0;
        int r = str.length() - 1;
        while (l < r) {
            if (!Character.isLetterOrDigit(str.charAt(l))) {
                l++;
            } else if (!Character.isLetterOrDigit(str.charAt(r))) {
                r--;
            } else {
                if (Character.toLowerCase(str.charAt(l)) != Character.toLowerCase(str.charAt(r))) {
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;

    }

    /**
     * 最⻓回文子串
     * Leetcode: LeetCode: 最⻓回文子串 给定一个字符串 s，找到 s 中最⻓的回文子串。你可以假设 s 的最大⻓度为1000。
     * 示例 1:
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba"也是一个有效答案。
     * 示例 2: 输入: "cbbd" 输出: "bb"
     */
    private static boolean longestPalindrome2(String str) {
        if (str.length() == 0) {
            return true;
        }
        int l = 0;
        int r = str.length() - 1;
        while (l < r) {
            if (!Character.isLetterOrDigit(str.charAt(l))) {
                l++;
            } else if (!Character.isLetterOrDigit(str.charAt(r))) {
                r--;
            } else {
                if (Character.toLowerCase(str.charAt(l)) != Character.toLowerCase(str.charAt(r))) {
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;

    }

    /**
     * 给你一个 m x n 的整数网格 accounts ，其中 accounts[i][j] 是第 i​​​​​​​​​​​​ 位客户在第 j 家银行托管的资产数量。返回最富有客户所拥有的 资产总量 。
     *
     * 客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：accounts = [[1,2,3],[3,2,1]]
     * 输出：6
     * 解释：
     * 第 1 位客户的资产总量 = 1 + 2 + 3 = 6
     * 第 2 位客户的资产总量 = 3 + 2 + 1 = 6
     * 两位客户都是最富有的，资产总量都是 6 ，所以返回 6 。
     * 示例 2：
     *
     * 输入：accounts = [[1,5],[7,3],[3,5]]
     * 输出：10
     * 解释：
     * 第 1 位客户的资产总量 = 6
     * 第 2 位客户的资产总量 = 10
     * 第 3 位客户的资产总量 = 8
     * 第 2 位客户是最富有的，资产总量是 10
     * 示例 3：
     *
     * 输入：accounts = [[2,8,7],[7,1,3],[1,9,5]]
     * 输出：17
     *  
     *
     * 提示：
     *
     * m == accounts.length
     * n == accounts[i].length
     * 1 <= m, n <= 50
     * 1 <= accounts[i][j] <= 100
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/richest-customer-wealth
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param accounts
     * @return
     */
    public int maximumWealth(int[][] accounts) {
        int count = 0;
        for (int[] account : accounts) {
            int temp = 0;
            for (int i : account) {
                temp = temp + i;
            }
            if (temp > count) {
                count = temp;
            }

        }
        return count;
    }


    /**
     *给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
     *
     * 请返回 nums 的动态和。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3,4]
     * 输出：[1,3,6,10]
     * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
     * 示例 2：
     *
     * 输入：nums = [1,1,1,1,1]
     * 输出：[1,2,3,4,5]
     * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
     * 示例 3：
     *
     * 输入：nums = [3,1,2,10,1]
     * 输出：[3,4,6,16,17]
     *  
     *
     * 提示：
     *
     * 1 <= nums.length <= 1000
     * -10^6 <= nums[i] <= 10^6
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/running-sum-of-1d-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] runningSum(int[] nums) {
        for(int i=1;i<nums.length;i++){
            nums[i]+=nums[i-1];
        }
        return nums;
    }

    /**
     *
     字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     示例 1：

     输入: s = "abcdefg", k = 2
     输出: "cdefgab"
     示例 2：

     输入: s = "lrloseumgh", k = 6
     输出: "umghlrlose"
      

     限制：

     1 <= k < s.length <= 10000

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String reverseLeftWords(String s, int n) {
       return s.substring(n)+s.substring(0,n);
    }

    public static void main(String[] args) {
        // String[] strs = {"flower", "flow", "alight"};
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(StringAlgorithm.replaceSpace(strs));
        String str = "ddccccdd";
        //   String str = "sefvgt";
        System.out.println(StringAlgorithm.longestPalindrome(str));
        System.out.println(StringAlgorithm.isPalindrome(str));
    }
}
