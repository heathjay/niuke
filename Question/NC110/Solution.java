import java.util.*;


public class Solution {
    /**
     * 旋转数组
     * @param n int整型 数组长度
     * @param m int整型 右移距离
     * @param a int整型一维数组 给定数组
     * @return int整型一维数组
     */
    public int[] solve (int n, int m, int[] a) {
        // write code here
        if(n == 0 || a == null) return a;
        m = m % n;
        int[] k = new int[n];
        for(int i = 0; i < n;i++){
            k[(i + m) %n] = a[i];
        }

        for(int i = 0; i < n; i++){
            a[i] = k[i];
        }
        return a;
    }


    public void rotate(int[] nums, int k){
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }
}