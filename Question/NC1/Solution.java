import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve (String s, String t) {
        // write code here
        int n = s.length(), m = t.length();

        int l = n > m ? n : m;
        char[] res = new char[l+1];
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        int carry = 0;
        while(l>0){
            char x = (n-1) >= 0 ? sarr[n-1] : '0';
            char y = (m-1) >= 0 ? tarr[m-1] : '0';
            carry += (x - '0') + (y - '0');
            res[l] = (char)(carry % 10 + '0');
            carry = carry / 10;
            n--;
            m--;
            l--;
        }
        if(carry == 1){
            res[0] = '1';
            return new String(res);
        }else{
            return (new String(res)).substring(1);
        }
    }
    public static void main(){
        char i = '0';
    }
}