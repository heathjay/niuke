class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        for(int i = 0; i < len-1; i++){
            if(nums[i] > nums[i+1]){
                return i;
            }
        }
        return len-1;
    }
}

