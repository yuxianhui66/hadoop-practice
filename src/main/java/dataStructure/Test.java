package dataStructure;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author yuxianhui
 * @create 2020-09-03 18:01
 **/
public class Test {
    @org.junit.Test
    public void test1() {
        // Test test = new Test();
        // a = {4, 2, 3, 5, 9, 6}  n=6 key = 7
        // a = {4, 2, 3, 5, 9, 6}  n=6 key = 6
        char[] a = {4, 2, 3, 5, 9, 6};
        int n = 6;
        char key = '6';
        int i = find(a, n, key);
        System.out.println(i);
    }

    int find(char[] a, int n, char key) {
        if (a == null || n <= 0) {
            return -1;
        }

        // 这里因为要将 a[n-1] 的值替换成 key，所以要特殊处理这个值
        if (a[n - 1] == key) {
            return n - 1;
        }

        // 把 a[n-1] 的值临时保存在变量 tmp 中，以便之后恢复。tmp=6。
        // 之所以这样做的目的是：希望 find() 代码不要改变 a 数组中的内容
        char tmp = a[n - 1];
        // 把 key 的值放到 a[n-1] 中，此时 a = {4, 2, 3, 5, 9, 7}
        a[n - 1] = key;

        int i = 0;
        // while 循环比起代码一，少了 i<n 这个比较操作
        while (a[i] != key) {
            ++i;
        }

        // 恢复 a[n-1] 原来的值, 此时 a= {4, 2, 3, 5, 9, 6}
        a[n - 1] = tmp;

        if (i == n - 1) {
            // 如果 i == n-1 说明，在 0...n-2 之间都没有 key，所以返回 -1
            return -1;
        } else {
            // 否则，返回 i，就是等于 key 值的元素的下标
            return i;
        }
    }

    int f(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int ret = 0;
        int pre = 2;
        int prepre = 1;
        for (int i = 3; i <= n; ++i) {
            ret = pre + prepre;
            prepre = pre;
            pre = ret;
        }
        return ret;
    }

    @org.junit.Test
    public void test2() {
        int f = f(8);
        System.out.println(f);
    }

    //冒泡排序
    void bubbleSort(int[] data) {
        int last = 0;
        for (int i = 0; i < data.length; i++) {
            boolean flag = false;
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    flag = true;
                }
            }
            last++;
            if (!flag) {
                break;
            }
        }
        System.out.println(last);
    }


    @org.junit.Test
    public void test3() {
        int[] a = {3, 4, 8, 10, 9, 43, 7, 8};
        bubbleSort(a);
        System.out.println(a);
    }

    void insertionSort(int[] data) {
        int last = 0;
        for (int i = 1; i < data.length; i++) {
            int value = data[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (value < data[j]) {
                    data[j + 1] = data[j];
                } else {
                    break;
                }
            }
            data[j + 1] = value;
            last++;
        }
        System.out.println(last);
    }

    public void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j + 1] = value; // 插入数据
        }
    }

    //插入排序
    public void insertionSort2(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int j = i - 1;
            int value = data[i];
            for (; j >= 0; j--) {
                if (data[j] > value) {
                    data[j + 1] = data[j];
                } else {
                    break;
                }
            }
            data[j + 1] = value;
        }
    }

    @org.junit.Test
    public void test4() {
//        10 12 11 7 15 13
//        10 12 11 7 15 13
        int[] a = {10, 12, 11, 7, 15, 13};
        insertionSort2(a);
        System.out.println(a);
    }

    //选择排序
    public void selectSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int j = i + 1;
            int value = data[i];
            int k = j;
            for (; j < data.length; j++) {
                if (data[j] < value) {
                    value = data[j];
                    k = j;
                }
            }
            if(value!=data[i]){
                data[k] = data[i];
                data[i] = value;
            }
        }
    }

    @org.junit.Test
    public void test5() {
//        10 12 11 7 15 13
//        10 12 11 7 15 13
        int[] a = {10, 12, 11, 7, 15, 11};
        selectSort(a);
        System.out.println(a);
    }

    //归并排序
    public int[] mergeSort(int[] data) {
        if(data.length<2){
            return data;
        }
        int middle = data.length/2;
        int[] left = Arrays.copyOfRange(data,0,middle);
        int[] right = Arrays.copyOfRange(data,middle,data.length);
        int[] tempLeft = mergeSort(left);
        int[] tempRight = mergeSort(right);
        return merge(tempLeft,tempRight);
    }

    private int[] merge(int[] left, int[] right) {
        int i=0;
        int j=0;
        int[] last = new int[left.length+right.length];
        int k=0;
        while(i<left.length&&j<right.length){
            if(left[i]<=right[j]){
                last[k++] = left[i];
                i++;
            }else {
                last[k++] = right[j];
                j++;
            }
        }
        if(i==left.length){
            for(int temp = j;temp<right.length;temp++){
                last[i+temp] = right[temp];
            }
        }
        if(j==right.length){
            for(int temp = i;temp<left.length;temp++){
                last[j+temp] = left[temp];
            }
        }
        return last;
    }


    @org.junit.Test
    public void test6() {
        int[] a = {10, 12, 11, 7, 15, 11,8,13};
        int[] last = mergeSort(a);
        System.out.println(last);
    }

    //快速排序
    private void quickSort(int[] data,int left,int right) {
        if(left>=right){
            return;
        }
        int temp = data[right];
        int begin = left;
        int end = right-1;
        while(begin<end){
            while (data[begin]<=temp&&begin<end){
                begin++;
            }
            while (data[end]>=temp&&begin<end){
                end--;
            }
            if(begin<end){
                swap(data,begin,end);
            }
        }
        if(data[begin]>temp){
            swap(data,begin,right);
        }
        quickSort(data,left,begin-1);
        quickSort(data,begin+1,right);

    }

    private void swap(int[] data, int begin, int end) {
        int temp = data[begin];
        data[begin] = data[end];
        data[end] = temp;
    }


    @org.junit.Test
    public void test7() {
        int[] a = {18, 17, 11, 7, 15, 11,8,13};
        quickSort(a,0,a.length-1);
        System.out.println(a);
    }

    //二分查找
    private int bsearch(int[] data,int value){
        int low = 0;
        int high = data.length-1;
        while (low<=high){
            int mid = (low+high)/2;
            if(data[mid]==value){
                return mid;
            }
            if(data[mid]>value){
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return -1;
    }

    //递归二分查找
    private int bsearch2(int[] data,int low,int high,int value){
        if(low>high){
            return -1;
        }
        int mid = low + (high-low)>>1;
        if(data[mid]==value){
            return mid;
        }
        if(data[mid]>value){
            high = mid-1;
        }else {
            low = mid+1;
        }
        return bsearch2(data,low,high,value);
    }

    //变体一：查找第一个值等于给定值的元素
    private int bsearch3(int[] data,int value){
        int low = 0;
        int high = data.length-1;
        while (low<=high){
            int mid = (low+high)/2;
            if(data[mid]>value){
                high = mid-1;
            }else if(data[mid]<value){
                low = mid+1;
            }else {
                if (mid == 0 || data[mid - 1] != value) {
                    return mid;
                }else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }

    //变体二：查找最后一个值等于给定值的元素
    private int bsearch4(int[] data,int value){
        int low = 0;
        int high = data.length-1;
        while (low<=high){
            int mid = (low+high)/2;
            if(data[mid]>value){
                high = mid-1;
            }else if(data[mid]<value){
                low = mid+1;
            }else {
                if (mid == data.length-1 || data[mid + 1] != value) {
                    return mid;
                }else {
                    low = mid+1;
                }
            }
        }
        return -1;
    }

    //变体三：查找第一个大于等于给定值的元素
    private int bsearch5(int[] data,int value){
        int low = 0;
        int high = data.length-1;
        while (low<=high){
            int mid = (low+high)/2;
            if(data[mid]>=value){
                if(mid==0||data[mid -1]<value){
                    return mid;
                }else {
                    high = mid-1;
                }
            }else {
                low = mid+1;
            }
        }
        return -1;
    }

    //变体四：查找最后一个小于等于给定值的元素
    private int bsearch6(int[] data,int value){
        int low = 0;
        int high = data.length-1;
        while (low<=high){
            int mid = (low+high)/2;
            if(data[mid]>value){
                high = mid-1;
            }else {
                if (mid == data.length-1 || data[mid + 1] > value) {
                    return mid;
                }else {
                    low = mid+1;
                }
            }
        }
        return -1;
    }

    @org.junit.Test
    public void test8() {
        int[] a = {7, 8, 11, 11, 13, 15,17,18};
      //  int i = bsearch(a,15);
        int i = bsearch2(a,0,a.length-1,15);
        System.out.println(i);
    }

    @org.junit.Test
    public void test9() {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= 5; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        System.out.println(dp);
    }
}
