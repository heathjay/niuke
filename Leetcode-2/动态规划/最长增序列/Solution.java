import java.util.*;


public class Solution {
    /**
     * retrun the longest increasing subsequence
     * @param arr int整型一维数组 the array
     * @return int整型一维数组
     */
    /*
    public int[] LIS (int[] arr) {
        // write code here
        int len = arr.length;
        if(len == 0) return arr;
        int[] dp = new int[len];
        dp[0] = 1;
        int max = 1;
        

        for(int i = 1; i < len; i++){
            dp[i] = 1;
            for(int j = 0; j < i ; j++){
                if(arr[i] > arr[j] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                    max = max > dp[i] ? max : dp[i];
                }
            }
        }

        int[] res = new int[max];
        for(int i = len - 1, j = max; j > 0; i--){
            if(dp[i] == j){
                j--;
                res[j] = arr[i];
            }
        }
        return res;
    }
    */


    //加入二分法
    public int[] LIS (int[] arr) {

        int len = arr.length;
        if(len == 0) return arr;

        int[] dp = new int[len];
        int[] tmp = new int[len];
        int end = 0;
        tmp[0] = arr[0];
        dp[0] = 1;
        for(int i = 1; i < len; i++){
            if(arr[i] > tmp[end]){
                end++;
                tmp[end] = arr[i];
                dp[i] = end;
            }else{
                int left = 0 , right = end;
                while(left < right){
                    int mid = (right - left) / 2 + left;
                    if(tmp[mid] > arr[i]){
                        right = mid;
                    }else{
                        left = mid + 1;
                    }
                }
                tmp[left] = arr[i];
                dp[i] = left;
            }
        }
        int[] ans = new int[end+1];

        for(int i = len-1, j = end; j >= 0 ; i--){
            if(dp[i] == j){
                ans[j] = arr[i];
                j--;
            }
        }
        return ans;
    }
}