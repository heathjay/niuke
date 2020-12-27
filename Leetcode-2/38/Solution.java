class Solution {
    public String countAndSay(int n) {
        if(n==1)return "1";
        char[] nums = countAndSay(n-1).toCharArray();

        int len = nums.length;
        int i = 0;
        int j = i+1;
        int count = 1;
        StringBuilder res = new StringBuilder();
        while(j < len){
            if(nums[i] == nums[j]){
                count++;
            }else{
                res.append(count + "").append(nums[i]);
                i = j;
                count=1;
            }
            j++;
        }
        res.append(count + "").append(nums[i]);
        return res.toString();

    }
}