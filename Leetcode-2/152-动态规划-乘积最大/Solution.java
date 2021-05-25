class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        if(len == 1) return nums[0];
        int maxNum = nums[0];
        int minNum = nums[0];
        int res = nums[0];
        for(int i = 1; i < len; i++){
            int tmp = maxNum;
            maxNum = Math.max(nums[i], Math.max(nums[i] * maxNum, nums[i] * minNum) );

            minNum = Math.min(nums[i], Math.min(nums[i]*tmp, nums[i] * minNum));
            res = Math.max(res, maxNum);
        }

        return res;
    }
}