class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if(len < 4) return res;

        Arrays.sort(nums);

        for(int i = 0 ; i < len - 3; i++){
            if(nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target){
                break;
            }
            if(nums[i] + nums[len-1] + nums[len-2] + nums[len-3] < target){
                continue;
            }

            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            for(int j = i+1; j < len-2; j++ ){
                if(nums[i] + nums[j] + nums[j+1] + nums[j+2] >target){
                    break;
                }

                if(nums[i] + nums[j] + nums[len-1]+nums[len-2] < target){
                    continue;
                }

                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }

                int left = j+1, right = len-1;

                while(left < right){

                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target){
                        ArrayList<Integer> t = new ArrayList<>();
                        t.add(nums[i]);
                        t.add(nums[j]);
                        t.add(nums[left]);
                        t.add(nums[right]);
                        res.add(t);
                        while(left < right && nums[left] == nums[left+1]){
                            left++;
                        }
                        left++;
                        while(right > left && nums[right] == nums[right-1]){
                            right--;
                        }
                        right--;
                    }else if(sum > target){
                        right--;
                    }else{
                        left++;

                    }

                }
            }
        }

        return res;
    }
}