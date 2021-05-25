class Solution {
    public int longestConsecutive1(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        if(len == 1) return 1;
        Arrays.sort(nums);
        int maxlen = 1;
        int i = 0;
        while(i < len-1){
            int curcount = 1;
            int j = i+1;
            while(j < len ){
                if(nums[j] == nums[j-1]){
                    j++;
                    continue;
                }
                if(nums[j] - nums[j-1] == 1) {
                    curcount++;
                    j++;
                }
                else{
                    break;
                }
            }
            if(curcount > 1){
                maxlen = Math.max(curcount, maxlen);
                i = j;
            }else{
                i++;
            }

        }
        return maxlen;
    }

    public int longestConsecutive(int[] nums) {
        //用set进行去重复
        Set<Integer> nums_set = new HashSet<>();
        for(int num : nums){
            nums_set.add(num);
        }

        int longestStreak = 0 ;
        //遍历set
        for(int num: nums_set){
            //跳过前有连续
            if(!nums_set.contains(num-1)){
                int currentNum = num;
                int currentStreak = 1;
                while(nums_set.contains(currentNum + 1)){
                    currentNum += 1;
                    currentStreak +=1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;


    }
}