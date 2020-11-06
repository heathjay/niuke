import java.util.*;


public class Solution {
    /**
     * 
     * @param numbers int整型一维数组 
     * @param target int整型 
     * @return int整型一维数组
     */
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        int[] res = new int[2];
        int n = numbers.length;
        for(int i = 0; i < n ; i++){
            int mid = target - numbers[i];
            for(int j = i+1; j < n ;j++){
                if(mid == numbers[j]){
                    res[0] = i;
                    res[1]=j;
                    return res;
                }
            }
        }
    }
}