class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if(len == 0) return;
        int i = len-2;
        while(i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }
        int j = len-1;
        if(i >= 0){
            while(j >= 0&& nums[j] <= nums[i]){
                j--;  
            }
             swap(nums, i, j);
           
        }
        reverse(nums, i+1);
    }

    public void swap(int[] nums, int i , int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j]=tmp;
    }

    public void reverse(int[] nums, int i){
        int left = i, right = nums.length-1;
        while(left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}