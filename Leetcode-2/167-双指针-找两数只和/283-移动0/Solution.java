class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int left = 0, right = 0;
        while(right < len){
            if(nums[right] != 0 ){
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left,int  right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}