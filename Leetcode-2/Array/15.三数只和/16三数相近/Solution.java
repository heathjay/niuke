class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        if(len < 3) return 0;
        Arrays.sort(nums);
        int min = 100000;
        for(int first = 0 ; first < len-2; first++){
            if(first > 0 && nums[first] == nums[first-1])continue;
           int second = first+1, third = len-1;
           while(second< third){
               int sum = nums[first] + nums[second] + nums[third];
               if(target == sum){
                   return target;
               }
                if(Math.abs(sum - target) < Math.abs(min - target)){
                    min = sum;
                }
               if(sum > target){
                 third--;
                   while(second < third && nums[third] == nums[third+1]){
                       third--;
                   }
                   
               }else{
                   second++;
                   while( second > first+1 && second < third && nums[second] == nums[second-1]){
                       second++;
                   }
                   
               }
           }
            
        }
        return min;
    }
}