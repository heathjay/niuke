import java.util.*;


public class Solution {
    /**
     * 找缺失数字
     * @param a int整型一维数组 给定的数字串
     * @return int整型
     */
    public int solve (int[] a) {
        // write code here
        int n = a.length;
        if(n == 0 || a == null) return 0;
        int sum = (n+1) * n / 2;
        for(int i=0; i < n; i++){
            sum-=a[i];
        }
        return sum;
    }

    public static void main(){
        int[] a = {0,1,2,3,4,5,7};
        System.out.println(solve(a));
    }
}