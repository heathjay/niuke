import java.util.*;


public class Solution {
    /**
     * pick candy
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int candy (int[] arr) {
        // write code here
        int len = arr.length;
        if(len == 0 || arr == null) return 0;
        int[] res = new int[len];

        int sum = 0;
        for(int i = 0; i < len - 1; i++){
            if(res[i] == 0){
                res[i] = 1;
            }
            if(arr[i+1] > arr[i]){
                res[i + 1] = res[i] + 1; 
            }
        }
        if(res[len-1] == 0) res[len-1] = 1;
        for(int i = len -1; i >0; i--){
            if(arr[i] < arr[i-1] && res[i] >= res[i-1]){
                res[i-1] = res[i]+1;
            }
            sum+=res[i];
        }
        return sum + res[0];
    }
}