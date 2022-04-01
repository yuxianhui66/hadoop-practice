package algorithm.stringalgorithm;

/**
 * @author yuxianhui
 * @create 2021-03-01 15:12
 **/
public class StringMultiply {

    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int m = num1.length();
        int n = num2.length();
        int[] mul = new int[m+n-1]; // 元素默认值为 0
        for(int i = 0; i < m; ++i) { // 竖式运算
            for(int j = 0; j < n; ++j) {
                int vi = num1.charAt(i) - 48;
                int vj = num2.charAt(j) - 48;
                mul[i+j] += vi*vj;
            }
        }
        for(int i = m+n-2; i > 0; --i) { // 进位
            mul[i-1] += mul[i]/10;
            mul[i] %= 10;
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < m+n-1; ++i) { // 结果拼接为字符串
            result.append(mul[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("12","123"));
    }
}
