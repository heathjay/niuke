class Solution {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0 || nums == null)return false;
        if(len == 1 ){
            if(nums[0] == target) return true;
            else return false;
        } 

        int left = 0, right = len-1;
        while(left <= right){
            int mid = (right - left) / 2 + left;

            if(nums[mid] == target){
                return true;
            }

            if(nums[left] == nums[right]){
                left++;
                continue;
            }
            //前等于很重要的
            if(nums[left] <= nums[mid] ){
                if(nums[mid] > target && target >= nums[left]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{
                if(nums[mid] < target && target <= nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return false;
      
    }
}