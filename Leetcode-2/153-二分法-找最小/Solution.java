class Solution {
    public int findMin(int[] nums) {
        int right = nums.length - 1;
        int left = 0;

        while(left < right){
            int mid = (right - left) / 2 + left;

            if(nums[mid] < nums[right]){
                right = mid;
            }else{
                left = mid +1;
            }
        }
        return nums[left];
    }
}