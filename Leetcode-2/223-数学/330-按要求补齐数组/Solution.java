class Solution {
    public int minPatches(int[] nums, int n) {
        int patches = 0;
        int x = 1;
        int index = 0;
        int length = nums.length;
        while(x <= n){
            if(index < length && nums[index] <= x){
                x += nums[index];
                index++;
            }else{
                x *= 2;
                patches++;
            }
        }
        return patches;
    }
}