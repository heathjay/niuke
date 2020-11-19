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
        quicksort(arr,0,arr.length);
    }
    private void quicksort(int[] arr, int left, int right){
        if(left > right){
            return;
        }

        int tmp = arr[left];
        int i = left;
        int j = right;
        while(i!=j){
            while(arr[j] >= tmp && i < j){
                j--;
            }

            while(arr[i] <= tmp && i <j){
                i++;
            }

            if(i < j ){
                int t  = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[left] = arr[i];
        arr[i] = tmp;


        quicksort(arr, left, i-1);
        quicksort(arr, i+1, right);
    }
}