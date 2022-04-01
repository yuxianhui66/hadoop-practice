package CSNotes;

/**
 * @author: xianhui.yu
 * @create: 2022-01-19 15:33
 **/
//在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
//
//        ```html
//        Input:
//        {2, 3, 1, 0, 2, 5}
//
//        Output:
//        2
//        ```
//
//        ##
public class RepeatNum {
    public static void main(String[] args) {
        int i = RepeatNum(new int[]{2, 2, 1, 3, 4, 5});
        System.out.println(i);

    }

    private static int RepeatNum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i]!=i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }else {
                    swap(i,nums[i],nums);
                }
            }
       //     swap(i,nums[i],nums);
        }
        return -1;
    }

    private static void swap(int i,int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
