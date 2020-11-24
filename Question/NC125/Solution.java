import java.util.*;


public class Solution {
    /**
     * max length of the subarray sum = k
     * @param arr int整型一维数组 the array
     * @param k int整型 target
     * @return int整型
     */
    public int maxlenEqualK (int[] arr, int k) {
        // write code here
        if(arr == null || arr.length == 0){
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int len = 0;
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(map.containsKey(sum - k)){
                len = Math.max(i - map.get(sum - k), len);
            }
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return len;
    }
}