import java.util.*;


public class Solution {
    /**
     * find median in two sorted array
     * @param arr1 int整型一维数组 the array1
     * @param arr2 int整型一维数组 the array2
     * @return int整型
     */
    public int findMedianinTwoSortedAray (int[] arr1, int[] arr2) {
        // write code here
        int N = arr1.length;
        if(N == 0) return 0;
        if(arr1[0] > arr2[N-1])return arr1[0];
        if(arr2[0] > arr1[N-1]) return arr2[0];
        int Aleft = 0 , Aright=N-1, Bleft=0, Bright=N-1;
        int Amid=0,Bmid=0;
        while(Aleft<= Aright && Bleft <= Bright){
            Amid = (Aleft + Aright) / 2;
            Bmid = (Bleft + Bright) / 2;
            if(arr1[Amid] == arr2[Bmid]){
                if(arr1[Amid + 1] > arr2[Bmid + 1]) return arr2[Bmid+1];
                else{
                    return arr1[Amid+1];
                }
            }
            if(arr1[Amid] < arr2[Bmid]){
                Aleft = Amid+1;
                Bright = Bmid -1;
            }
            if(arr1[Amid] > arr2[Bmid]){
                Aright = Amid -1;
                Bleft = Bmid +1;
            }
        }
        return arr1[Amid + 1] > arr2[Bmid+1] ? arr2[Bmid+1] : arr1[Amid+1];
    }
}