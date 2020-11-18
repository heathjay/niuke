import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 
     * @param s string字符串 第一个整数
     * @param t string字符串 第二个整数
     * @return string字符串
     */
    public String solve (String s, String t) {
        // write code here
        if(s.equals("0") || t.equals("0")) return "0";
        int m = s.length(), n = t.length();
        int[] array = new int[m + n];
        for(int i = m - 1 ; i >= 0; i--){
            for(int j = n-1; j >= 0 ; j--){
                int x = s.charAt(i) - '0';
                int y = t.charAt(j) - '0';
                array[i+j + 1] += x * y;
            }
        }

        for(int i = m + n - 1; i > 0 ; i--){
            array[i-1] += array[i] / 10;
            array[i] %= 10;
        }

        int index = array[0] == 0 ? 1 : 0;
        StringBuffer sb = new StringBuffer();
        while(index < m + n){
            sb.append(array[index]);
            index++;
        }
        return sb.toString();
    }
}