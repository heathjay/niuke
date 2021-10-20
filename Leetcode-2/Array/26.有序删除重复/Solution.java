class Solution{
    public int removeD(int[] nums){
        int len = nums.length;
        if(len <= 1) return len;
        int fast = 1 , slow =1;
        while(fast < len){
            if(nums[fast] != nums[fast-1]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}