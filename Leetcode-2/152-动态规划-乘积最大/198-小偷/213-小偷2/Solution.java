class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        if(len == 1) return nums[0];
        if(len == 2) return Math.max(nums[0],nums[1]);
        return Math.max(rangeRob(0, len-2, nums), rangeRob(1,len-1,nums));
    }

    public int rangeRob(int start, int end, int[] nums){
        int first = nums[start];
        int second = Math.max(nums[start+1], nums[start]);

        for(int i = start+2; i <= end;i++){
            int tmp = second;
            second = Math.max(first+nums[i], tmp);
            first = tmp;
        }
        return second;
    }

}