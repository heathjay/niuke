class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0) return -1;
        int left = 0, right = len-1;
        while(left <= right){
            int mid = (left+ right)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[left] <= nums[mid]){
                if(target >= nums[left] && target < nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{
                if(target <= nums[right] && target > nums[mid]){
                    left=mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}