import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0){
            return 0;
        }
        int low = 0;
        int high = array.length - 1;
        int mid = 0;
        while(low < high){
            if(array[low] < array[high]){
                return array[low];
            }
            mid = (low + high) >> 1;
            if(array[low] < array[mid]){
                low = mid + 1;
            }else if (array[mid] < array[high]){
                high=mid;
            }else{
                low++;
            }
        }
        return array[low];
    }
}