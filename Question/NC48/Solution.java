import java.util.*;


public class Solution {
    /**
     * 
     * @param A int整型一维数组 
     * @param target int整型 
     * @return int整型
     */
    public int search (int[] A, int target) {
        // write code here
        int len = A.length;
        if(len == 0 || A == null) return 0;
        int left = 0, right = len - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(A[mid] == target) return mid;
            if(A[mid] >= A[left]){
                if(A[mid] > target && A[left] <= target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if(A[mid] < target && A[right] >= target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}