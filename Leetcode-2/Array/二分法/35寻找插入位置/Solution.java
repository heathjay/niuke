class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if(len == 0) return 0;
        int left = 0, right = len - 1;
        int ans = len;
        while(left<= right){
            int mid = (right-left) / 2 + left;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target){
                right=mid-1;
                ans=mid;
            }else{
                left=mid+1;
            }
            
        }
        return ans;
    }
}