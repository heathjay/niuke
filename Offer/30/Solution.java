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
}