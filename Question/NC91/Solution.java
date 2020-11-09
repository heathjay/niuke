import java.util.*;


public class Solution {
    /**
     * retrun the longest increasing subsequence
     * @param arr int整型一维数组 the array
     * @return int整型一维数组
     */
    public int[] LIS (int[] arr) {
        // write code here
        int[] dp = new int[arr.length];//存储当前位置最长子序列长度
        int[] tem = new int[arr.length+1];//存储最长子序列的数组，且是字典序的
        dp[0] = 1;//第一个元素独自成序
        int len = 1;
        tem[1] = arr[0];//第一个元素独自成序为自身
        for (int i = 0; i < arr.length; i++) {
            if (tem[len] < arr[i]){
                tem[++len] = arr[i];//如果递增则放入tem数组中
                dp[i] = len;//记录长度
            }else {
                //否则在tem中用二分查找寻找替换位置
                int l = 0;
                int r = len;
                while (l<=r){
                    int mid = (l+r)>>1;
                    if (tem[mid] >= arr[i]){
                        r = mid-1;
                    }else l = mid+1;
                }

                tem[l] = arr[i];
                dp[i] = l;
            }


        }
        //字典序最小，如果dp中长度相同，那么在后面的那个肯定是小于前面的，所以从后往前查找
        int[] res = new int[len];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (dp[i] == len) {
                res[--len] = arr[i];
            }
        }
        return res;

    }
}
