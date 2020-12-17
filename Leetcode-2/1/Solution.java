import java.util.Map;
import java.util.HashMap;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res= new int[2];
        if(nums == null || nums.length == 0) return res;
        for(int i = 0; i < nums.length; i++){
            int tmp = target - nums[i];
            if(map.containsKey(tmp) && map.get(tmp) != i){
                res[0] = map.get(tmp);
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}