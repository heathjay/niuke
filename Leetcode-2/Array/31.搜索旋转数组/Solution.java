class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len <= 0) return -1;
        int left = 0, right = len - 1;

        if (len == 1) {
            return nums[0] == target ? 0 : -1;
        }
        while(left <= right){
            int mid = (right - left) / 2 + left;
            if(nums[mid] == target) return mid;
            if(nums[mid] >= nums[left]){
                if(target >= nums[left] && target < nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }

            if(nums[mid] <= nums[right]){
                if(target>nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right=mid-1;
                }
            }
        }

        return -1;
    }
}