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
        Map<Integer, Integer> map = new HashMap<>();
        for(int cur = 0, tmp ; cur < numbers.length; cur++){
            tmp = numbers[cur];
            if(map.containsKey(target-tmp)){
                return new int[]{map.get(target-tmp) +1 ,cur + 1};
            }
            map.put(tmp,cur);
        }
        return null;
    }
}