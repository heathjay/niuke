import java.util.*;


public class Solution {
    /**
     * 
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength (int[] arr) {
        // write code here
        Map<Integer, Integer> map = new HashMap<>();
        int right = 0, left = 0, max =0;

        for(int tmp = 0, cur; right < arr.length; right++){
            cur = arr[right];
            if(map.containsKey(cur) && map.get(cur) >= left){
                tmp = right - left+1;
                left = map.get(cur) + 1;
            }

            map.put(cur, right);
            max = tmp > max ? tmp: max;
        }
        return max;
    }
}