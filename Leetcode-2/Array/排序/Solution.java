import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 将给定数组排序
     * @param arr int整型一维数组 待排序的数组
     * @return int整型一维数组
     */
    public int[] MySort (int[] arr) {
        // write code here
        int len = arr.length;
        if(len <= 0) return arr;
        quickSort(arr, 0, len-1);
        return arr;
    }
    public void quickSort(int[] arr, int start, int end){
        if(start < end){
            int tmp = arr[start];
            int index = start;
            for(int j = start + 1; j <= end; j++){
                if(arr[j] < tmp){
                    index++;
                    int t = arr[index];
                    arr[index] = arr[j];
                    arr[j] = t;
                }
            }
            arr[start] = arr[index];
            arr[index] = tmp;
            quickSort(arr, start, index-1);
            quickSort(arr, index+1, end);
        }


    }
}