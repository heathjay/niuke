import java.util.*;


public class Solution {
    /**
     * 最少货币数
     * @param arr int整型一维数组 the array
     * @param aim int整型 the target
     * @return int整型
     */
    public int minMoney (int[] arr, int aim) {
        // write code here
        if(aim < 1){
            return 0;
        }

        return change(arr, aim, new int[aim]);
    }

    public int change(int[] coins, int rem, int[] count){
        if(rem < 0){
            return -1;
        }

        if(rem == 0){
            return 0;
        }

        if(count[rem - 1] != 0){
            return count[rem - 1];
        }


        for(int coin : coins){
            int res = change(coins, rem -coin, count);
            if(res >= 0 && res < min){
                min = 1 + res;
            }
        }

        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem-1];
    }
}


public class Solution1 {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
