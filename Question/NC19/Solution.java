import java.util.*;


public class Solution {
    /**
     * max sum of the subarray
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxsumofSubarray (int[] arr) {
        // write code here
        for(int i = 1; i < arr.length-1; i++){
            if(arr[i] + arr[i-1] > arr[i]){
                arr[i] = arr[i] + arr[i-1];
            }
        }
        return arr[arr.length - 1] > 0 ? arr[arr.length -1] + arr[arr.length -2] : arr[arr.length -2];
    }
}