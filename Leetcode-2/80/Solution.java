class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len <= 2) return 2;
        int slow = 2, fast = 2;
        while(fast < len){
            if(nums[slow-2] != nums[fast]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}