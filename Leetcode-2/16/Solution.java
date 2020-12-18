import java.util.Arrays;
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best =nums[0] + nums[1] + nums[2];

        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int third = n-1;
            int sec = i+1;
            while(sec < third){
                if(sec > i+1 && nums[sec] == nums[sec-1]){
                    sec++;
                    continue;
                }
                int sum = nums[sec] + nums[third] + nums[i];
                if(sum == target){
                    return target;
                }
                if(Math.abs(sum - target) < Math.abs(best-target)){
                    best = sum;
                }
                if(sum > target){
                    third--;
                }else{
                    sec++;
                }
            }
        }
        return best;
    }
}