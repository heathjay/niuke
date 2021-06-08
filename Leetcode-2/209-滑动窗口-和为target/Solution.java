class Solution {
    public int minSubArrayLen1(int target, int[] nums) {
        int res =  Integer.MAX_VALUE;;
        int len = nums.length;

        for(int i = 0 ; i <len; i++ ){
            if(target<= nums[i]){
                return 1;
            }

            if(target > nums[i]){
                int sum = 0;
                for(int j = i ; j < len; j++){
                    sum+= nums[j];
                    if(target <= sum){
                        res = Math.min(res, (j-i+1));
                        break;
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }


    public int minSubArrayLen(int target, int[] nums) {

        int res = Integer.MAX_VALUE;
        int len = nums.length;
        if(len == 0) return 0;


        int start = 0, end = 0;
        int sum = 0;
        while(end < len){
            sum += nums[end];
            while(sum >= target){
                res = Math.min(res, end - start + 1);
                sum -= nums[start];
                start++;
            }

            end++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}