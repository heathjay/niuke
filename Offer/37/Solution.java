public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        if(array.length == 0 || k < array[0] || k > array[array.length - 1]) return 0;
       int left = 0, right = array.length - 1;
       int count = 0;
       int found = 0;
       int mid = -1;
        while(left < right){
            mid = (left + right) / 2;
            if(array[mid] >k){
                right = mid - 1;
            }else if(array[mid] <k){
                left = mid + 1;
            }else{
                count++;
                found=mid;
                break;
            }
        }
        for(int i = mid + 1;i < array.length && array[i] == k; i++) count++;
        for(int i = mid - 1; i >= 0 && array[i] == k; i--) count++;
        return count;
    }
}