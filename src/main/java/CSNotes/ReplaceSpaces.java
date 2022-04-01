package CSNotes;

import scala.reflect.internal.TypeDebugging;

/**
 * @author: xianhui.yu
 * @create: 2022-01-20 14:12
 **/
//将一个字符串中的空格替换成 "%20"。
//
//        ```text
//        Input:
//        "A B"
//
//        Output:
//        "A%20B"
//        ```
//
//        ##
public class ReplaceSpaces {
    public static void main(String[] args) {
        String str = "A B";
        System.out.println(ReplaceSpaces(str));
    }
    private static String ReplaceSpaces(String str){
        int len = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i)==' '){
                len++;
            }
        }
        int charLength = (str.length()-len)+3*len-1;
        char[] c  = new char[charLength+1];
        for(int i = str.length()-1; i >=0 ; i--){
            if(str.charAt(i)==' '){
                c[charLength--] = '0';
                c[charLength--] = '2';
                c[charLength--] = '%';
            }else {
                c[charLength--] = str.charAt(i);
            }
        }
        return String.valueOf(c);
    }
}
