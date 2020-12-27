class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
         if(len == 0 || nums == null) return res;
        int left = 0, right = len - 1;

        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                int j = mid-1;
                while(j>=0&& nums[j] == target){
                    j--;
                }
                res[0] = j+1;
                j = mid+1;
                while(j<=len-1 &&nums[j] == target){
                    j++;
                }
                res[1] = j-1;
                return res;
            }

            if(nums[mid] > target){
                right = mid-1;
            }else{
                left = mid + 1;
            } 
        } 
        return res; 
    }
}