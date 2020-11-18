import java.util.*;


public class Solution {
    /**
     * 
     * @param x int整型 
     * @return bool布尔型
     */
    public boolean isPalindrome (int x) {
        // write code here
        if(x < 0) return false;
        int res = 0;
        int x1 = x;
        while(x!= 0){
            if((res == Integer.MAX_VALUE / 10 && x % 10 >7) || res > Integer.MAX_VALUE/10) return false;
            res = res * 10 + x % 10;
            x = x/10;
        }

        return (res == x1 || x / 10 == 0);
    }
}