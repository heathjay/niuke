class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if(len == 0 || nums==null)return -1;
        int left = 0, right = len - 1;
        int res = len;
        while(left <= right){
            int mid = (left+right) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                res = mid;
                right = mid - 1;
            }else{
                left = mid +1;
            }
        }
        return res;
    }
}