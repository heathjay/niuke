import java.util.*;


public class Solution {
    /**
     * 
     * @param n int整型 
     * @param m int整型 
     * @return int整型
     */
    public int ysf (int n, int m) {
        // write code here
        return f(n,m) + 1;
    }

    public int f(int n, int m){
        if(n == 1){
            return 0;
        }

        int x = f(n-1,m);
        return (m + x) % n;
    }
}