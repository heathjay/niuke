import java.util.List;
import java.util.ArrayList;
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<ArrayList<>>();

        int len = nums.length;
        if(len == 0 || nums == null) return res;
        Arrays.sort(nums);
        for(int i = 0; i < len - 3; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            if(nums[i] + nums[i + 1] + nums[i+2] + nums[i+3] > target ){
                break;
            }
            for(int j=  i+1; j < len - 2; j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int left = j+1, right = len -1;
                while(left<right){
                    int sum = nums[left] + nums[right] + nums[i] + nums[j];
                    if(sum == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[left],nums[right]));
                        //处理重复
                        while(left< right && nums[left] == nums[left +1]){
                            left++;
                        }
                        left++;
                        while(right > left && nums[right] == nums[right-1]){
                            right--;
                        }
                        right--;
                    }else if(sum < target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return res;
    }
}