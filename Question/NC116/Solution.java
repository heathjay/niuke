import java.util.*;


public class Solution {
    /**
     * 解码
     * @param nums string字符串 数字串
     * @return int整型
     */
    public int solve (String nums) {
        // write code here
        if(nums.charAt(0)=='0'){
            return 0;
        }
        int [] dp = new int [nums.length()+1];//长度为n时，的排列组合种类
        dp[0] = 1;
        dp[1] = 1;
        if(nums.length()==1)   return dp[1];
        for(int i=2;i<=nums.length();i++){
            int num = Integer.valueOf(String.valueOf(nums.charAt(i-1)));//得到当前数；
            int nums2 = Integer.valueOf(String.valueOf(nums.charAt(i-2)));//得到当前数的前一个数
            if (nums2+num==0||(num==0&&nums2>2)){
                return 0;
            }else if(num==0||nums2==0){
                dp[i] = num==0?dp[i-2]:dp[i-1];
            }else{
                dp[i] = nums2*10+num>26?dp[i-1]:dp[i-2]+dp[i-1];
            }

        }
        return dp[nums.length()];


    }
}