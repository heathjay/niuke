import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 
     * @param a string字符串 待计算字符串
     * @return int整型
     */
    public int solve (String s) {
        // write code here
        int n = s.length();
        int len = n/2;
        int max_len = 0;

        for(int i = len; i  > 0 ; i --){
            for(int s = 0; s <= n-i -i; s++ ){
                if(judge(a.s,i)){
                    max_len= Math.max(i*2, max_len);
                }
            }
        }
        return max_len;
    }
    public boolean judge(String s, int n, int len){
        for(int i = n; i < n + len; i++){
            if(s.charAt(i)!= s.charAt(i+len)){
                return false;
            }
        }
        return true;
    }
}