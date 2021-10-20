import java.util.*;


public class Solution {
    /**
     * 
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength (int[] arr) {
        // write code here
        Map<Integer,Integer> map = new HashMap<>();
        int len = arr.length;
        if(len <= 1)return len;
        int maxCur = 0;
        int left = -1;
        for(int i = 0; i < len; i++){
            if(map.containsKey(arr[i])){
                left = Math.max(left, map.get(arr[i]));
            }
            maxCur = Math.max(maxCur, i - left);
                                map.put(arr[i],i );
        }
        return maxCur ;
    }
}