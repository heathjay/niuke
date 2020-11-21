import java.util.*;


public class Solution {
    /**
     * 寻找最后的山峰
     * @param a int整型一维数组 
     * @return int整型
     */
    public int solve (int[] a) {
        // write code here
        int len = a.length;
        
        if(len == 0 || a == null) return Integer.MIN_VALUE;
        if(len == 1 )return a[0];
        for(int i = len-1; i >= 0 ;i--){
            if(i==len-1){
                if(a[i] > a[i-1]){
                    return len-1;
                }
            }else if(i==0){
                if(a[i] > a[i+1]){
                    return 0;
                }
            }else{
                if(a[i] > a[i+1]){
                    if(a[i] > a[i-1]){
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}