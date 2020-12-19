class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len == 0|| nums == null)return 0;
        if(len == 1) return 1;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i+1;
    }
}