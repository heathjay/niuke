class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        if(len == 0) return null;
        Arrays.sort(nums);
        
        int maxValue = nums[0];
        int maxSize = 1;
        int[] dp = new int[len];
        dp[0] = 1;
        for(int i = 1 ; i < len; i++ ){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                   
                }
                
            }

            if(dp[i] > maxSize){
                maxSize = dp[i];
                maxValue = nums[i];
            }
        }
        
        List<Integer> res = new ArrayList<>();
        if(maxSize == 1) {
            res.add(nums[0]);
            return res;
        }
        for(int i = len-1; i >=0 && maxSize > 0 ; i--){
            if(maxSize == dp[i]&& maxValue % nums[i] == 0 ){
                maxSize--;
                res.add(nums[i]);
                maxValue = nums[i];
            }
        }
        return res;
    }
}