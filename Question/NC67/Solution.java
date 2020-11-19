public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0) return 0;


        int max = array[0];
        int localmax = array[0];
        for(int i = 1; i < array.length;i++){
            localmax = Math.max(array[i], localmax + array[i]);
            max = Math.max(max, localmax);
        }
        return max;
    }
}