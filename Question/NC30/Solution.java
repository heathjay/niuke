import java.util.*;


public class Solution {
    /**
     * return the min number
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int minNumberdisappered (int[] arr) {
        // write code here
        
        int len = arr.length;
        for(int i = 0; i < len; i++){
            while(arr[i] >= 1 && arr[i] <= len && arr[arr[i] - 1] != arr[i]){
                swap(arr, i, arr[i] - 1);
            }
        }

        for(int i = 0 ; i < len; i++){
            if(arr[i] != i+1){
                return i + 1;
            }
        }

        return len + 1;
    }

    public void swap(int[] arr, int index1, int index2){
        int tmp = arr[index1];
        arr[index1] =  arr[index2];
        arr[index2] = tmp;
    }
}