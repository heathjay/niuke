class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if(len == 0) return res;
        int t = -1;
        int left = 0 , right = len - 1;
        while(left <= right){
            int mid = (right - left) / 2 + left;
            if(nums[mid] == target) {
                t = mid;
                break;
            }
            if(target > nums[mid]) left = mid+1;
            if(target < nums[mid]) right = mid - 1; 
        }

        if(t != -1){
            left = t;
            while(left >= 0 && nums[left] == target ){
                left--;
            }
            right = t;
            while(right < len && nums[right] == target){
                right++;
            }
            res[0] = left+1;
            res[1] = right-1;
        }
        return res;
    }
}