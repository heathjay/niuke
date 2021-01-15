class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if(len == 0) return true;
        int max = nums[0];
        int end = nums[0];
        for(int i = 0; i < len; i++){
            if(end >= len-1){
                return true;
            }

            for(int start = i; start<= end; start++){
                max = Math.max(max, start + nums[start]);
            }
            end = max;
        }
        return false;
    }
    public boolean canJump1(int[] nums) {
        int n = nums.length;
        int right = 0;
        for(int i = 0; i < n; i++){
            if(i <= right){
                right = Math.max(right, i+nums[i]);
                if(right >= n-1){
                    return true;
                }
            }
        }
        return false;
    }
}