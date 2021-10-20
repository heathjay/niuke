import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        int len = nums.length;
        if(len < 3) return res;

        for(int i = 0 ; i < len-2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int third = len-1;
            int target = -nums[i];
            for(int second = i + 1; second < len-1 ; second++){
                if(second > i + 1 && nums[second] == nums[second - 1]) continue;

                while(third > second && nums[second] + nums[third] > target){
                    third--;
                }

                if(second == third) break;
                if(nums[second] + nums[third ]== target){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[second]);
                    tmp.add(nums[third]);
                    res.add(tmp);
                }
            }
            return res;
        }

    }
}