import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0) return 0;

        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while(left < right){
            if(array[left] < array[right]){
                return array[left];
            }

            mid = (left + right) >> 1;
            if(array[left] < array[mid]){
                left = mid + 1;
            }else if(array[mid] < array[right]){
                right = mid;
            }else{
                left++;
            }
        }
        return array[left];

    }
}