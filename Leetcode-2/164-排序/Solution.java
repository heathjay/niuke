class Solution {
    public int maximumGap(int[] nums) {
        int len =nums.length;
        if(len == 0 || len==1) return 0;
        Arrays.sort(nums);

        int max = 0;
        for(int i = 0; i < len-1; i++){
          
           max= Math.max(max, nums[i+1] - nums[i]);
        }

        return max;
    }
}