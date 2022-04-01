package CSNotes;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xianhui.yu
 * @create: 2022-01-20 17:31
 **/
//在一个字符串中找到第一个只出现一次的字符，并返回它的位置。字符串只包含 ASCII 码字符。
//
//        ```
//        Input: abacc
//        Output: b
//        ```
//
//        ##
public class FirstAppearString {
    public static void main(String[] args) {
        String str="acaccd";
        System.out.println(FirstAppearString(str));
    }
    private static int FirstAppearString(String str){
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<str.length();i++){
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
        }
        for (int i = 0; i < str.length(); i++){
            if(map.get(str.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}
