import java.util.*;


public class Solution {
    /**
     * 
     * @param x int整型 
     * @return int整型
     */
    //二分法
    public int sqrt (int x) {
        // write code here
        if(x <= 0){
            return 0;
        }
        int left = 1, right =x;
        while(true){
            int mid = (left + right) >> 1;
            if(mid <= x / mid && (mid + 1) > x / (mid + 1)){
                return (int) mid;
            }else if(mid < x / mid){
                left = mid+1;
            }else{
                right = mid - 1;
            }
        }

    }
}