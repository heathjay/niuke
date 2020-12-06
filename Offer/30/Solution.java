public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int maxSum = array[0];
        int localMaxSum = array[0];
        for(int i = 1; i < array.length; i++){
            localMaxSum = Math.max(array[i], localMaxSum + array[i]);
            maxSum = Math.max(localMaxSum,maxSum);
        }
        return maxSum;
    }

    public int FindGreatestSumOfSubArray(int[] array) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while(high != 0 || cur != 0){
            if(cur == 0) res += high * digit;
            else if(cur == 1) res += high * digit + low +1;
            else res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;

    }

}