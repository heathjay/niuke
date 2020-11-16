import java.util.*;


public class Solution {
    /**
     * 
     * @param x int整型 
     * @return int整型
     */
    public int reverse (int x) {
        // write code here
        int res = 0;
        while(x != 0){
            int p = x %10;
            x = x/10;
            if(res > Integer.MAX_VALUE / 10 ||(res == Integer.MAX_VALUE / 10 && p > 7)) return 0;
            if(res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && p < -8)) return 0;
            res = res * 10 + p;
        }
        return res;
    }
}